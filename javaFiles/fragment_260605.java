class MyInputStream {
    boolean closeCalled = false;

    @Override
    public int read() throws IOException {
        return -1;
    }

    @Override
    public void close() throws IOException {
        closeCalled = true;
        super.close();
    }

    boolean getCloseCalled() {
        return closeCalled;
    }
};
MyInputStream stream = new MyInputStream();