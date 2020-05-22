public Url mapHandler(IRequestHandler requestHandler) {
        Url url = delegate.mapHandler(requestHandler);
        switch (checker.getProtocol(requestHandler)){
            case HTTP :
                url.setProtocol("http");
                url.setPort(httpsConfig.getHttpPort());
                break;
            case HTTPS :
                url.setProtocol("https");
                url.setPort(httpsConfig.getHttpsPort());
                break;
        }
        return url;
    }