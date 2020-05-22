public Response performRequest(String method, String endpoint, Map<String, String> params,
                                   HttpEntity entity, HttpAsyncResponseConsumerFactory httpAsyncResponseConsumerFactory,
                                   Header... headers) throws IOException {
        SyncResponseListener listener = new SyncResponseListener(maxRetryTimeoutMillis);
        performRequestAsync(method, endpoint, params, entity, httpAsyncResponseConsumerFactory, listener, headers);
        return listener.get();
    }