File file = new File("/path/to/image.jpg");
response.setContentType("image/jpeg");
response.setHeader("Content-Length", String.valueOf(file.length()));

InputStream input = new FileInputStream(file);
OutputStream output = response.getOutputStream();
byte[] buffer = new byte[8192];

try {
    for (int length = 0; (length = input.read(buffer)) > 0;) {
        output.write(buffer, 0, length);
    }
}
finally {
    try { input.close(); } catch (IOException ignore) {}
    try { output.close(); } catch (IOException ignore) {}
}