class MyServiceImpl implements MyService<DummyResponse, DummyRequest> {

    // This now implements MyService correctly. 
    @Override
    public DummyResponse getResponse(DummyRequest request) {
        //do sth
        return response;
    }

}