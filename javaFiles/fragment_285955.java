providers.add(new ResponseExceptionMapper<WebApplicationException>() {

    @Override
    public WebApplicationException fromResponse(Response r) {
        return new WebApplicationException(r);
    }

});

YourService proxy = JAXRSClientFactory.create(url, clazz,providers);
Client client = WebClient.client(proxy);
WebClient.getConfig(client).getInInterceptors().add(new MyInterceptor());