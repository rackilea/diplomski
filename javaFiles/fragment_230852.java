public static byte[] readBytesAndClose(InputStream in) throws IOException {
    try {
        int block = 4 * 1024;
        ByteArrayOutputStream out = new ByteArrayOutputStream(block);
        byte[] buff = new byte[block];
        while (true) {
            int len = in.read(buff, 0, block);
            if (len < 0) {
                break;
            }
            out.write(buff, 0, len);
        }
        return out.toByteArray();
    } finally {
        in.close();
    }
}