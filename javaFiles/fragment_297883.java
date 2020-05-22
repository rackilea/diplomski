final URL url = new URL("http://localhost:8080/SearchPerson.aspx/PersonSearch");
final URLConnection urlConnection = url.openConnection();
urlConnection.setDoOutput(true);
urlConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
urlConnection.connect();
final OutputStream outputStream = urlConnection.getOutputStream();
outputStream.write(("{\"fNamn\": \"" + stringData + "\"}").getBytes("UTF-8"));
outputStream.flush();
final InputStream inputStream = urlConnection.getInputStream();