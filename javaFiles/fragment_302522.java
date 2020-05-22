sendRequest(ACTION_BALANCE, null, new JsonObjectFutureCallback() { 
    @Override
    public void onCompleted(Exception e, JsonObject result) {
        // my code goes here
    }
});

// OR just

sendRequest(ACTION_OPERATIONS, null, new JsonArrayFutureCallback() { 
    @Override
    public void onCompleted(Exception e, JsonArray result) {
        // my code goes here
    }
});