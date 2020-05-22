MyRouteBuilder(Endpoint servletEndpointStart, MockEndpoint mockEndpointEnd, String allowedParameters){
        this._servletEndpoint = servletEndpointStart;
        this._mockEndpoint = mockEndpointEnd;
    }

    @Override
    public void configure() throws Exception {
        from(this._servletEndpoint)
        .id(TESTING_ROUTE_NAME)
        .process(new Processor(){ // some processor })
        .to(_mockEndpoint);
    }