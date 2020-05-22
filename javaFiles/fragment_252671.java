setRootRequestMapper(new HttpsMapper(getRootRequestMapper(), new HttpsConfig(8080, 8443)){
    @Override
    public Url mapHandler(IRequestHandler requestHandler) {
        Url url = super.mapHandler(requestHandler);
        if ("https".equals(url.getProtocol)){
            // Force the HostName for HTTPS requests
            url.setHost("securepage.example.com");   
        }
        return url;
    }
});