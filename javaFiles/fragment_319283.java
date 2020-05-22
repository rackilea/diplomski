ByteBuffer b = ByteBuffer.allocate((int)blob.getSize());
BlobstoreInputStream in = new BlobstoreInputStream(blob.getBlobKey());
byte[] buf = new byte[8192];
int bytes = 0;
while((bytes = in.read(buf)) != -1)
    b.put(buf, 0, bytes);
b.flip();
...