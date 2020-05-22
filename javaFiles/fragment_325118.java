String urlName = "https://api.stackexchange.com/2.2/users?site=stackoverflow";
URL url = new URL(urlName);
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("GET");
if (conn.getResponseCode() != 200) {
    throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
}
InputStream inputStream = conn.getInputStream();

if ("gzip".equals(conn.getContentEncoding())) {
    // Is compressed using GZip: Wrap the reader
    inputStream = new GZIPInputStream(inputStream);
}

InputStreamReader streamReader = new InputStreamReader(inputStream);
BufferedReader bufferedReader = new BufferedReader(streamReader);
StringBuilder builder = new StringBuilder();
String line;
while ((line = bufferedReader.readLine()) != null) {
    builder.append(line + "\n");
}
conn.disconnect();