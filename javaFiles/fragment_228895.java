final Dispatcher dispatcher = new Dispatcher() {

    @Override
    public MockResponse dispatch (RecordedRequest request) throws InterruptedException {

        switch (request.getPath()) {
            case "/v1/login/auth/":
                return new MockResponse().setResponseCode(200);
            case "v1/check/version/":
                return new MockResponse().setResponseCode(200).setBody("version=9");
            case "/v1/profile/info":
                return new MockResponse().setResponseCode(200).setBody("{\\\"info\\\":{\\\"name\":\"Lucas Albuquerque\",\"age\":\"21\",\"gender\":\"male\"}}");
        }
        return new MockResponse().setResponseCode(404);
    }
};
server.setDispatcher(dispatcher);