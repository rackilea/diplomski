class SocketWrapper extends Socket {
    private CountingInputStream input;

    @Override
    public InputStream getInputStream() throws IOException {
        if (input == null) {
            input = new CountingInputStream(super.getInputStream());
        }

        return input;
    }

    public int getInputCounter() {
        return input.getCounter();
    }

    // other stuff like getOutputStream
}

class CountingInputStream extends InputStream {
    private final InputStream inputStream;

    public CountingInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    @Override
    public int read() throws IOException {
        counter++;
        return inputStream.read();
    }

    // other methods
}