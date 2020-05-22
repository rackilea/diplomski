response.setContentLength(getContentLength());
byte[] buffer = new byte[10240];

try (
    InputStream input = getInputStream();
    OutputStream output = response.getOutputStream();
) {
    for (int length = 0; (length = input.read(buffer)) > 0;) {
        output.write(buffer, 0, length);
    }
}