URL url = new URL("http://host:port/file.xml");
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setRequestMethod("GET");
connection.setRequestProperty("Accept","application/xml");
InputStream is = connection.getInputStream();
FileOutputStream fos = new FileOutputStream("localfile_os.xml");
IOUtils.copy(is, fos);
is.close();
fos.close();