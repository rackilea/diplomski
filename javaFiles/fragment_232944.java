// FileChannel using jcifs.smb.SmbRandomAccessFile

package smb4jackcess;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbRandomAccessFile;

public class SmbFileChannel extends FileChannel {
    private final SmbRandomAccessFile _file;
    private long _length;

    public SmbFileChannel(String smbURL) throws SmbException, MalformedURLException, UnknownHostException {
        _file = new SmbRandomAccessFile(smbURL, "rw", SmbFile.FILE_NO_SHARE);
        _length = _file.length();
    }

    @Override
    public void force(boolean metaData) throws SmbException, MalformedURLException, UnknownHostException {
        // do nothing
    }

    @Override
    public FileLock lock(long position, long size, boolean shared) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MappedByteBuffer map(MapMode mode, long position, long size) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long position() throws SmbException {
        return _file.getFilePointer();
    }

    @Override
    public FileChannel position(long newPosition) throws SmbException {
        _file.seek(newPosition);
        return this;
    }

    @Override
    public int read(ByteBuffer dst) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int read(ByteBuffer dst, long position) throws SmbException {
        byte[] b = new byte[dst.remaining()];
        _file.seek(position);
        int bytesRead =_file.read(b);
        dst.put(b);
        return bytesRead;
    }

    @Override
    public long read(ByteBuffer[] dsts, int offset, int length) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long size() throws SmbException {
        return _length;
    }

    @Override
    public long transferFrom(ReadableByteChannel src, long position, long count) throws IOException {
        ByteBuffer bb = ByteBuffer.allocate((int)count);
        int bytesWritten = src.read(bb);
        bb.rewind();
        bb.limit(bytesWritten);
        this.write(bb, position);
        return bytesWritten;
    }

    @Override
    public long transferTo(long position, long count, WritableByteChannel target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FileChannel truncate(long newSize) throws SmbException {
        if (newSize < 0L) {
            throw new IllegalArgumentException("negative size");
        }
        _file.setLength(newSize);
        _length = newSize;
        return this;
    }

    @Override
    public FileLock tryLock(long position, long size, boolean shared) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int write(ByteBuffer src) throws SmbException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int write(ByteBuffer src, long position) throws SmbException {
        byte[] b = new byte[src.remaining()];
        src.get(b);
        _file.seek(position);
        _file.write(b);

        long endPos = position + b.length;
        if(endPos > _length) {
            _length = endPos;
        }

        return b.length;
    }

    @Override
    public long write(ByteBuffer[] srcs, int offset, int length) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void implCloseChannel() throws SmbException {
        _file.close();
    }

}