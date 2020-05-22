URL.setURLStreamHandlerFactory(new URLStreamHandlerFactory() {
    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {
       if ("android".equals(protocol)){
           return new Handler();
       }
       return null;
    }
});