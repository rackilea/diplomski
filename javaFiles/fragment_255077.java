static class CustomHttpConnection extends DefaultBHttpClientConnection {

    public CustomHttpConnection(final int buffersize) {
        super(buffersize);
    }

    @Override
    public SessionInputBuffer getSessionInputBuffer() {
        return super.getSessionInputBuffer();
    }
}