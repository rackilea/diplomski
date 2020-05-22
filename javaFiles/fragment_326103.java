TwitterRestClient.get("statuses/public_timeline.json", null, new JsonHttpResponseHandler() {
    // other methods overrides

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        FailureClass.handlerMethod(statusCode, headers, responseBody, error);
    }
}