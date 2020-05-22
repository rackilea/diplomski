downloadStream = connection.getInputStream();
ByteArrayOutputStream out = new ByteArrayOutputStream();
byte[] buffer = new byte[1024];
while (!needsCancel) {
    int r = downloadStream.read(buffer);
    if (r == -1) break;
    out.write(buffer, 0, r);
}
d = Drawable.createFromStream(new ByteArrayInputStream(out.toByteArray()), null);