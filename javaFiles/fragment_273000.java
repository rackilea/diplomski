public static String getResponseBody(HttpResponse response) {
    ResponseHandler<String> responseHander = new BasicResponseHandler();
    String responseBody = null;
    try {
        responseBody = (String) responseHander.handleResponse(response);
    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    logger.debug("Response Body Data:" + responseBody);

    return responseBody;
}