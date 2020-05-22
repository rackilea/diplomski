class MyBufferedOutputStream extends java.io.BufferedOutputStream {

    public MyBufferedOutputStream(OutputStream out) {
        super(out);
    }

    /** throw away everything in a buffer without writing it */
    public synchronized void skip() {
        count = 0; 
    }

}