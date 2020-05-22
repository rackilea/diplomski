HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
try {
    String content = IOUtils.toString(urlConnection.getInputStream(), Charset.defaultCharset());
    return (content.isEmpty() ? null : content);
} finally {
    urlConnection.disconnect();
}