private String readContent(final String urlAsString) {
    final StringBuilder content = new StringBuilder();
    BufferedReader reader = null;
    InputStream inputStream = null;
    try {
        final URL url = new URL(urlAsString);
        inputStream = url.openStream();
        reader =
            new BufferedReader(new InputStreamReader(inputStream);

        String inputLine;
        while ((inputLine = reader.readLine()) != null) {
            content.append(inputLine);
        }
    } catch (final IOException exception) {
        exception.printStackTrace();
    } finally {
        IOUtils.closeQuietly(reader);
        IOUtils.closeQuietly(inputStream);
    }
    return content.toString();
}