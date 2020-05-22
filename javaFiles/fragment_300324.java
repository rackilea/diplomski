client.addFilter(new ClientFilter() {
    private ArrayList<Object> cookies;

    @Override
    public ClientResponse handle(ClientRequest request) throws ClientHandlerException {
        if (cookies != null) {
            request.getHeaders().put("Cookie", cookies);
        }
        ClientResponse response = getNext().handle(request);
        if (response.getCookies() != null) {
            if (cookies == null) {
                cookies = new ArrayList<Object>();
            }
            // simple addAll just for illustration (should probably check for duplicates and expired cookies)
            cookies.addAll(response.getCookies());
        }
        return response;
    }
});