// Adding authentication headers when encountering EVENT_TRANSPORT
mSocket.io().on(Manager.EVENT_TRANSPORT, new Emitter.Listener() {
    @Override
    public void call(Object... args) {
        Transport transport = (Transport) args[0];
        // Adding headers when EVENT_REQUEST_HEADERS is called
        transport.on(Transport.EVENT_REQUEST_HEADERS, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.v(TAG, "Caught EVENT_REQUEST_HEADERS after EVENT_TRANSPORT, adding headers");
                Map<String, List<String>> mHeaders = (Map<String, List<String>>)args[0];
                mHeaders.put("Authorization", Arrays.asList("Basic bXl1c2VyOm15cGFzczEyMw=="));
            }
        });
    }
});