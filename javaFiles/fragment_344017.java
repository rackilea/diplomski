private String readResponse(HttpResponse httpresponse) throws IOException {
        int responseCode = httpresponse.getStatusLine().getStatusCode();
        String mimeType = httpresponse.getFirstHeader(CONTENT_TYPE_KEY).getValue();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            String cause = String.format("Bad HTTP response code: %d\nOr MIME type: %s", responseCode, mimeType);
            throw new IOException(cause);
        }
        return EntityUtils.toString(httpresponse.getEntity());
    }