String foo = "value";
ByteArrayOutputStream baos = new ByteArrayOutputStream();

try (GZIPOutputStream gzos = new GZIPOutputStream(baos)) {
    gzos.write(foo.getBytes("UTF-8"));
}

byte[] fooGzippedBytes = baos.toByteArray();