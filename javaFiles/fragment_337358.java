....
url = new URL(fileUrl);
URLConnection connection = url.openConnection();
connection.connect();
String temp = connection.getHeaderField("fileType");
pathToSave = pathToSave + "." + temp;