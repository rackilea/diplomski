URL url = new URL(imgUrl);
URLConnection connection = url.openConnection();
connection.connect();

int fileLength = connection.getContentLength();
InputStream inputStream = url.openStream();

DataInputStream dis = new DataInputStream(is);