class MyInputStream extends InputStream {
    InputStream in;
    int count;
    boolean even = false;

    public MyInputStream(InputStream stream){
        this.in = stream;
    }

    @Override
    public int read() throws IOException {
        return this.in.read();
    }

    @Override
    public int read(byte[] toStore) throws IOException {
        return this.in.read(toStore);
    }
}