String url = "uploading url";
String charset = "UTF-8";
String param = "value";
File binaryFile = new File("/path/to/file.bin");
String boundary = Long.toHexString(System.currentTimeMillis()); // Just generate some unique random value.
String CRLF = "\r\n"; // Line separator required by multipart/form-data.

URLConnection connection = new URL(url).openConnection();
connection.setDoOutput(true);
connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

try {
    OutputStream output = connection.getOutputStream();
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, charset), true);
     // Send binary file.
    writer.append("--" + boundary).append(CRLF);
    writer.append("Content-Disposition: form-data; name=\"binaryFile\"; filename=\"" + binaryFile.getName() + "\"").append(CRLF);
    writer.append("Content-Type: " + URLConnection.guessContentTypeFromName(binaryFile.getName())).append(CRLF);
    writer.append("Content-Transfer-Encoding: binary").append(CRLF);
    writer.append(CRLF).flush();
    Files.copy(binaryFile.toPath(), output);
    output.flush(); // Important before continuing with writer!
    writer.append(CRLF).flush(); // CRLF is important! It indicates end of boundary.

    // End of multipart/form-data.
    writer.append("--" + boundary + "--").append(CRLF).flush();
}

// Request is lazily fired whenever you need to obtain information about response.
int responseCode = ((HttpURLConnection) connection).getResponseCode();
System.out.println(responseCode); // Should be 200