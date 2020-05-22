/**
 * 
 */
package objtest;

import java.io.IOException;
import java.nio.ByteBuffer;

import koku.util.io.ByteBufferOutputStream;

/**
 * UnrealConceptTest - FramedOutputStream
 * @version 1.0
 * @author Chris Dennett
 */
public class FramedOutputStream extends ByteBufferOutputStream {
    public static final int FRAME_HEADER_1 = 0xBEEFFACE;
    public static final int FRAME_HEADER_2 = 0xFACEBEEF;

    public static final byte[] HEADER_BYTES = new byte[4 * 2];
    public static final byte[] CURR_HEADER_BUFF = new byte[HEADER_BYTES.length];

    /* We pad the beginning of our buffer so that we can write the frame
     * length when the time comes. */
    protected static final byte[] SIZE_PAD = new byte[4];

    static {
        ByteBuffer b = ByteBuffer.allocate(8);

        b.putInt(FRAME_HEADER_1);
        b.putInt(FRAME_HEADER_2);

        ByteBuffer b2 = (ByteBuffer) b.flip();

        b2.get(HEADER_BYTES, 0, 4);
        b2.get(HEADER_BYTES, 3, 4);
    }

    /**
     * 
     */
    public FramedOutputStream() {
        try {
            write(HEADER_BYTES);
            write(SIZE_PAD);
        } catch (IOException e) {
            System.out.println("Couldn't write header padding!");
        }
    }

    /* (non-Javadoc)
     * @see koku.util.io.ByteBufferOutputStream#flip()
     */
    @Override
    public ByteBuffer flip() {
        // flip the buffer which will limit it to it's current position
        super.flip();

        // then write the frame length and rewind back to the start of the
        // buffer so that all the data is available        
        _buffer.position(11);
        int size = _buffer.remaining();

        //System.out.println("remaining after complete header: " + size);

        _buffer.position(7);

        //System.out.println("remaining after frameheader: " + _buffer.remaining());

        putSizeAsBytes(size, _buffer);

        //System.out.println("written size: " + size);

       // System.out.println("buffer limit: " + _buffer.limit());

        //System.out.println("_buffer: " + new String( _buffer.array(), 0, _buffer.limit()));

        _buffer.position(11);

       // System.out.println("_buffer11: " + ObjTest.getByteStr(_buffer.get()));
        //System.out.println("_buffer12: " + ObjTest.getByteStr(_buffer.get()));
        //System.out.println("_buffer13: " + ObjTest.getByteStr(_buffer.get()));
        //System.out.println("_buffer14: " + ObjTest.getByteStr(_buffer.get()));

        _buffer.rewind();

        //_buffer.rewind();

        //while (_buffer.hasRemaining()) {
        //  byte b = _buffer.get();
        //  System.out.println("b: " + (b > 32 ? new String(new byte[] {b}) : "??") + ", " + b);
        //}

        _buffer.rewind();

        return _buffer;
    }

    /* (non-Javadoc)
     * @see koku.util.io.ByteBufferOutputStream#reset()
     */
    @Override
    public void reset() {
        super.reset();

        try {
            write(HEADER_BYTES);
            write(SIZE_PAD);
        } catch (IOException e) {
            System.out.println("Couldn't write header padding!");
        }
    }

    public static void putSizeAsBytes(int size, ByteBuffer bb) {
        //System.out.println("putSizeAsBytes: given size: " + size);

        // encode
        for (int i = 0; i < 4; i++) {
            bb.put((byte)((size >>> ((8 * 3) - (8 * i))) & 0xFF));
        }
    }
}