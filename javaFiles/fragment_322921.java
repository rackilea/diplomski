String url = "http://www.url.com/";
String charset = "ISO-8859-1";
String param1 = "value1";
String param2 = "value2";
String param3 = "value3";

String query = String.format("param1=%s&param2=%s&param2=%s", 
     URLEncoder.encode(param1, charset),
     URLEncoder.encode(param2, charset),
     URLEncoder.encode(param3, charset));

URLConnection connection = new URL(url).openConnection();
connection.setDoOutput(true); // Triggers POST.
connection.setRequestProperty("Accept-Charset", charset);
connection.setRequestProperty("Content-Type",
    "application/x-www-form-urlencoded;charset=" + charset);
connection.addRequestProperty("Cookie", session.get("COOKIE"));
OutputStream output = null;
try {
     output = connection.getOutputStream();
     output.write(query.getBytes(charset));
} finally {
     if (output != null) try { output.close(); } catch (IOException logOrIgnore) {}
}
InputStream responseStream = connection.getInputStream();

StringWriter writer = new StringWriter();
IOUtils.copy(responseStream, writer);
String response = writer.toString();