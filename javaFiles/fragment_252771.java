Blob blob = rs.getBlob(column);
InputStream in = blob.getBinaryStream();
OutputStream out = new FileOutputStream(someFile);
byte[] buff = new byte[4096];  // how much of the blob to read/write at a time
int len = 0;

while ((len = in.read(buff)) != -1) {
    out.write(buff, 0, len);
}