ByteArrayOutputStream bff = new ByteArrayOutputStream();

int nRead;
byte[] data = new byte[16384];
byte[] pickledStream;
while ((nRead = in.read(data, 0, data.length)) != -1) {
    bff.write(data, 0, nRead);
}
pickledStream = bff.toByteArray();