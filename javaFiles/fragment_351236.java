String encoding = ServletRequest.getCharacterEncoding();
if (encoding == null)
    encoding = "UTF-8";

// First read all input data    
while ((bytesRead = responseData.read(buffer)) > 0) {
    baos.write(buffer, 0, bytesRead);
}

// We have all input, now convert it to String:
String text = baos.toString(encoding);