InputStream is = new BufferedInputStream(getClass().getResourceAsStream(name));
ByteArrayOutputStream out = new ByteArrayOutputStream();
for (int b; (b = is.read()) != -1;) {
    out.write(b);
}
byte[] a = out.toByteArray();