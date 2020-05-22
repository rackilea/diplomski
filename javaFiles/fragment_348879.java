final URL url = new URL("http://server.com?queryParam={%22address1%22%3A%2277+tehama%22%2C%}");
final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setRequestMethod("POST");

final Response response;
try (InputStream inputStream = connection.getInputStream()) {
   response = objectMapper.readValue(inputStream, Response.class);
} catch (final Exception e) {
   log.error("Error when calling API", e);
}