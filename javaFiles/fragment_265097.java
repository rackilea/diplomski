try {
    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
    readStream(in);
}
finally {
    urlConnection.disconnect();
}