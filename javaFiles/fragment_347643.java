package de.whatever.uw.utils;

import java.io.BufferedInputStream;

/**
 * @author U. Windl
 */
public class RandomAccessFileInputStream extends BufferedInputStream {

    private RandomAccessFile file;  // file to use

   /**
     * Constructor
     * @param fileName File to open for reading
     * @throws FileNotFoundException 
     */
    public RandomAccessFileInputStream(String fileName) throws FileNotFoundException {
        super(System.in);   // dummy to work around Java's inflexibility
        assert fileName != null;
        file = new RandomAccessFile(fileName, "r");
        FileChannel channel = file.getChannel();
        in = new BufferedInputStream(Channels.newInputStream(channel));
        assert file != null;
    }

    /**
     * Forbidden Constructor
     * @param in Input stream
     */
    private RandomAccessFileInputStream(InputStream in) {
        super(in);
    }

    /**
     * Forbidden Constructor
     * @param in
     * @param size
     */
    private RandomAccessFileInputStream(InputStream in, int size) {
        super(in, size);
    }

    /* (non-Javadoc)
     * @see java.io.BufferedInputStream#close()
     */
    public void close() throws IOException {
        super.close();
        file.close();
    }

    /**
     * @return Current offset in stream
     * @throws IOException
     */
    public long getFilePointer() throws IOException {
        return file.getFilePointer();
    }

    /**
     * @return
     * @throws IOException
     * @see java.io.RandomAccessFile#length()
     */
    public long length() throws IOException {
        return file.length();
    }

    /**
     * @param pos New stream position
     * @throws IOException
     */
    public void seek(long pos) throws IOException {
        file.seek(pos);
        pos = count = 0;    // invalidate stream buffer
    }

    // other methods are inherited without change (and I really use a very few of them actually)
}