public static File  downloadFile(String fileURL, String saveDir)
    throws IOException {

File downloadFolder = null;
String saveFilePath = null;

String username = "guest";
String password = "guest";

String usepass = username + ":" + password;
String basicAuth = "Basic "+  javax.xml.bind.DatatypeConverter.printBase64Binary(usepass.getBytes());

URL url = new URL(fileURL);
HttpURLConnection httpConn = (HttpURLConnection) website.openConnection();
httpConn.setRequestProperty("Authorization", basicAuth);

ReadableByteChannel rbc = Channels.newChannel(httpConn.getInputStream());
String    fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,fileURL.length()); 
FileOutputStream fos = new FileOutputStream(fileName);

saveFilePath = saveDir + File.separator + fileName;
downloadFolder = new File(saveDir);

downloadFolder.deleteOnExit();
downloadFolder.mkdirs();

FileOutputStream outputStream = new FileOutputStream(saveFilePath);
outputStream.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

outputStream.close();
rbc.close();
return new File(saveFilePath);