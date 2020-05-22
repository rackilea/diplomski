byte[] data = org.apache.commons.codec.binary.Base64.decodeBase64(request.getParameter("image").getBytes());
String filename = request.getParameter("filename");

OutputStream output = new FileOutputStream(new File(getUploadFolder() + filename + ".png"));

try {
    output.write(data);
}
finally {
    output.close();
}