public static void sendFile(DataOutput out, String filename) throws IOException {
    FileInputStream fis = new FileInputStream(filename);
    byte[] bytes = new byte[8192];
    try {
        long size = fis.getChannel().size();
        out.writeLong(size);
        for (int len; (len = fis.read(bytes, 0, (int) Math.min(bytes.length, size))) > 0; ) {
            out.write(bytes, 0, len);
            size -= len;
        }
        assert size == 0;
    } finally {
        fis.close();
    }
}

public void receiveFile(DataInput in, String filename) throws IOException {
    long size = in.readLong();
    FileOutputStream fos = new FileOutputStream(filename);
    byte[] bytes = new byte[8192];
    try {
        for (int len; (len = (int) Math.min(size, bytes.length)) > 0; ) {
            in.readFully(bytes, 0, len);
            fos.write(bytes, 0, len);
            size -= len;
        }
    } finally {
        fos.close();
    }
}