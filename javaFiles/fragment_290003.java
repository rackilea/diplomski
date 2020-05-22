public Request<?> getMessage(int messageId, boolean maxBodySize, Response.Listener<MessageData> responseListener, Response.ErrorListener errorListener) {

    String url = apiURL + MESSAGE + "?";
    int method = Request.Method.GET;
    GsonRequest<MessageData> request = new GsonRequest<MessageData>(
            method,
            url,
            MessageData.class,
            null,
            responseListener,
            errorListener,
            gson) {
        @Override
        public Map<String, String> getHeaders() {
            HashMap<String, String> headers = new HashMap<String, String>();
            headers.put("Accept", "application/json");
            return headers;
        }
    };

    request.setRetryPolicy(new DefaultRetryPolicy(
            SOCKET_TIMEOUT_MS,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

    return mQueue.add(request);
}