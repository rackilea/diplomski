public static Response getResponse(HttpUrl url, OkHttpClient client) throws IOException {
    Builder request = new Request.Builder().url(url);
    Response response = client.newCall(request.build()).execute();
    if (!response.isSuccessful()) {
        boolean repeatRequest = handleHttpError(response);
        if (repeatRequest)
            return getResponse(url, client, etag);
        else
            throw new IOException(String.format("Cannot get successful response for url %s", url));
    }
    return response;
}