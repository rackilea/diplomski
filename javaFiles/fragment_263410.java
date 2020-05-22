import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.Serializable;

/**
 * John 
 * Fall 2012
 */ 

public class FLRAF extends RandomAccessFile implements Serializable {
    private int blockSize;

    public FLRAF(int blockSize, String file) throws IOException {
        super(file, "rw");
        this.blockSize = blockSize;
    }

    public byte[] read(int blockNumber) throws IOException {
        seek(blockNumber*blockSize);
        byte[] b = new byte[blockSize];
        read(b);
        return b;
    }

    public void write(byte[] b, int blockNumber) throws IOException {
        seek(blockNumber*blockSize);
        write(b);
        return;
    }
}