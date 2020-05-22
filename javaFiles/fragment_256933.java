// Send request to server and catch any errors.
RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);

try {
    Request request = builder.sendRequest(null, new RequestCallback() {
        public void onError(Request request, Throwable exception) {
            displayError("Couldn't retrieve JSON");
        }

        public void onResponseReceived(Request request, Response response) {
            if (200 == response.getStatusCode()) {
                updateTable(JsonUtils.safeEval(response.getText()));
            } else {
                displayError("Couldn't retrieve JSON (" + response.getStatusText() + ")");
            }
        }
    });
} catch (RequestException e) {
    displayError("Couldn't retrieve JSON");
}