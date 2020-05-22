URL.setURLStreamHandlerFactory(protocol -> "customuri".equals(protocol) ? new URLStreamHandler() {
    protected URLConnection openConnection(URL url) throws IOException {
        return new URLConnection(url) {
            public void connect() throws IOException {
                System.out.println("Connected!");
            }
        };
    }
} : null);