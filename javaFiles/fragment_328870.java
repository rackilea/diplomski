Map<String,byte[]> map = new HashMap<>();
ZipEntry entry;
byte[] read = new byte[1024];
while((entry = in.getNextEntry()) != null) {
    ByteArrayOutputStream r = new ByteArrayOutputStream(Math.max(128, entry.getSize()));
    int i;
    while((i = in.read(read) >= 0)
        r.write(read, 0, i);
    is.close();
    map.put(entry.getName(), r.toByteArray());
}