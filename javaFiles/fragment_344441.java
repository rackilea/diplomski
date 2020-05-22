/**
 * 
 */
package objtest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Queue;

import kokuks.KokuKS;

/**
 * UnrealConceptTest - FramedInputStream
 * @version 1.0
 */
public class FramedInputStream extends InputStream {
    public static final int INITIAL_BUFFER_SIZE = 8 << 1;

    public static final int FRAME_HEADER_1 = 0xBEEFFACE;
    public static final int FRAME_HEADER_2 = 0xFACEBEEF;

    public static final byte[] HEADER_BYTES = new byte[4 * 2];
    protected static final byte[] CURR_HEADER_BUFF = new byte[HEADER_BYTES.length];

    static {
        ByteBuffer b = ByteBuffer.allocateDirect(8);

        b.putInt(FRAME_HEADER_1);
        b.putInt(FRAME_HEADER_2);

        ByteBuffer b2 = (ByteBuffer) b.flip();

        b2.get(HEADER_BYTES, 0, 4);
        b2.get(HEADER_BYTES, 3, 4);
    }   

    protected int     size         = 0;
    protected int     chain        = 0;
    protected boolean inFrame      = false;
    protected boolean readingSize  = false;
    protected int     sizePos      = 0;

    protected int dbgput = 0;


    protected ByteBuffer        bb  = ByteBuffer.allocateDirect(INITIAL_BUFFER_SIZE);
    protected Queue<ByteBuffer> bbq = new ArrayDeque<ByteBuffer>();
    protected ByteBuffer        currBuff = null;

    protected final boolean     recoverFromError;

    /**
     * 
     */
    public FramedInputStream(boolean recoverFromError) {
        this.recoverFromError = recoverFromError;
    }

    public FramedInputStream() {
        this(true);
    }

    protected boolean ensureFramebufferCapacity(int min) {
        int mymin = 1 << min;

        if (mymin <= bb.capacity()) return false;

        int num = bb.capacity();
        while (num < mymin) num <<= 1;

        ByteBuffer bb2 = ByteBuffer.allocateDirect(num);
        // copy old data into new bytebuffer
        int bb_pos = bb.position();
        bb.rewind();
        bb2.put(bb);
        bb = bb2;

        if (KokuKS.DEBUG_MODE) System.out.println("modified buffer size to: " + num);

        return true;
    }

    /**
     * @return the recoverFromError
     */
    public boolean isRecoverFromError() {
        return recoverFromError;
    }

    /* (non-Javadoc)
     * @see java.io.InputStream#read()
     */
    @Override
    public int read() throws IOException {
        if (currBuff == null || !currBuff.hasRemaining()) return -1;

        byte b = currBuff.get();
        //System.out.println("data: " + b);
        return b;
    }

    public void putBuffer(ByteBuffer source) {
        ensureFramebufferCapacity(bb.capacity() + source.remaining());

        while (source.hasRemaining()) {
            putByte(source.get());
        }
    }

    public boolean checkCompleteFrame() {
        return !bbq.isEmpty();
    }

    /* (non-Javadoc)
     * @see java.io.InputStream#available()
     */
    @Override
    public int available() throws IOException {
        return currBuff != null ? currBuff.remaining() : 0;
    }

    public int read(byte[] data) {
        if (currBuff == null || !currBuff.hasRemaining()) {
            return -1;
        }

        if (data.length > currBuff.remaining()) {
            throw new BufferUnderflowException();
        }

        currBuff.get(data);

        //System.out.println("data: " + new String(data));

        return data.length;
    }

    public boolean nextFrame() {
        ByteBuffer bbf = bbq.poll();

        if (bbf != null) {
            /*
            System.out.println("bbf limit: " + bbf.limit());
            System.out.println("bbf pos: " + bbf.position());
            System.out.println("bbf data: " + new String(bbf.array()));
            */

            //byte[] data = bbf.array();

            //for (int i = 0; i < data.length; i++) {
            //  byte by = data[i];
            //  System.out.println("b: " + (by > 32 ? new String(new byte[] {by}) : "??") + ", " + by);
            //}         

            currBuff = ByteBuffer.allocateDirect(bbf.limit());
            currBuff.put(bbf).flip();
            bbf.rewind();

            /*
            System.out.println("currbuf limit: " + currBuff.limit());
            System.out.println("currbuf pos: " + currBuff.position());
            System.out.println("currbuf data: " + new String(currBuff.array()));
            */

            currBuff.rewind();
            currBuff.position(1);

            return true;
        }

        return false;
    }


    public void putByte(byte b) {
        //System.out.println("pb b: " + ObjTest.getByteStr(b));

        if (recoverFromError || !inFrame) {
            if (b == HEADER_BYTES[chain++]) {

                if (chain >= (HEADER_BYTES.length)) {
                    if (KokuKS.DEBUG_MODE) System.out.println("got header!" + (inFrame ? " (recovered)" : ""));

                    // we have a header! hurrah.
                    inFrame = true;
                    sizePos = 0;
                    size = 0;
                    readingSize = true;
                    chain = 0;

                    bb.clear();
                }
            } else {
                chain = 0;
            }
        }

        if (inFrame) {
            if (readingSize) {
                size += (b & 0xFF) << ((8 * 3) - (8 * sizePos));
                //System.out.println("new size: " + size);
                sizePos++;

                if (sizePos >= 4) {
                    // we've read the size :)
                    readingSize = false;
                    sizePos = 0;

                    ensureFramebufferCapacity(size);
                    bb.clear();
                    bb.limit(size); // set buffer limit to size
                    //System.out.println("bb limit set to: " + bb.limit());
                }
            } else {
                //System.out.println("put: " + dbgput++ + ", " + ObjTest.getByteStr(b));
                bb.put(b);

                if (!bb.hasRemaining()) {
                    bb.flip();

                    //System.out.println("bb limit after flip(): " + bb.limit());

                    //System.out.println("bblimit: " + bb.limit());

                    ByteBuffer newbuf = ByteBuffer.allocateDirect(bb.limit());
                    newbuf.put(bb).flip(); //we have to flip this
                    bbq.offer(newbuf); 

                    //byte[] data = newbuf.array();

                    //for (int i = 0; i < newbuf.limit(); i++) {
                    //  byte by = data[i];
                    //  System.out.println("b: " + (by > 32 ? new String(new byte[] {by}) : "??") + ", " + by);
                    //}

                    inFrame = false;
                    readingSize = false;
                    size = 0;
                    sizePos = 0;
                    chain = 0;

                    bb.clear();

                    if (KokuKS.DEBUG_MODE) System.out.println("FIS: complete object");
                    //System.out.println("FIS: newbuf: " + new String(newbuf.array(), 0, newbuf.limit()));
                }
            }
        }
    }
}