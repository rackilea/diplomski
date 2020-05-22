public class ReverseFileInputStream extends InputStream {
    private RandomAccessFile in;
    private byte[] buffer;
    // The index of the next byte to read.
    private int bufferIndex;
    public ReverseFileInputStream(File file) {
        this.in = new RandomAccessFile(File, "r");
        this.buffer = new byte[4096];
        this.bufferIndex = this.buffer.length;
        this.in.seek(file.length());
    }
    public void populateBuffer() throws IOException {
        // record the old position
        // seek to a new, previous position
        // read from the new position to the old position into the buffer
        // reverse the buffer
    }
    public int read() throws IOException {
        if (this.bufferIndex == this.buffer.length) {
            populateBuffer();
            if (this.bufferIndex == this.buffer.length) {
                return -1;
            }
        }
        return this.buffer[this.bufferIndex++];
    }
    // other overridden methods
}