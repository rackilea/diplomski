HttpURLConnection connection =(HttpURLConnection)new URL("url").openConnection();
connection.setDoOutput(true);
connection.setRequestProperty("Content-type", "text/xml"); // depend on you
connection.setRequestProperty("Accept", "text/xml, application/xml"); // depend on you
connection.setRequestMethod("POST");
OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
writer.write(yaml);
writer.close();
int statusCode = connection.getResponseCode();
String message = connection.getResponseMessage();