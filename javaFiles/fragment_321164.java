URL url = new URL("https://stackoverflow.com");
HttpURLConnection urlConnection = (HttpURLConnection)  url.openConnection();
urlConnection.setRequestProperty("Accept", "application/json");
try {
    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
    ...
} finally {
    urlConnection.disconnect();
}