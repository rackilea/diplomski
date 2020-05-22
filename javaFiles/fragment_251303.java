@Override
    public InputStream getBody() throws IOException {
        InputStream errorStream = this.connection.getErrorStream();
        this.responseStream = 
(errorStream != null ? errorStream : this.connection.getInputStream());
        return this.responseStream;
    }