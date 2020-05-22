class MarkerInputStream extends FilterInputStream {
    MarkerInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        if (isAtMarker()) {
            return -1;
        }
        // may need to read from a cache depending on what isAtMarker method does.
        return super.read();
    }

    private boolean isAtMarker() {
        // logic for determining when you're at the end of the image portion
        return false;
     }
}