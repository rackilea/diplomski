public static void sendFile(DataOutputStream out, String fileName) throws IOException {
    FileInputStream fis = new FileInputStream(fileName);
    try {
        byte[] bytes = new byte[8192];
        int len;
        out.writeInt((int) fis.getChannel().size());
        while ((len = fis.read(bytes)) > 0)
            out.write(bytes, 0, len);
    } finally {
        fis.close();
    }
}

public static void recvFile(DataInputStream in, String fileName) throws IOException {
    FileOutputStream fos = new FileOutputStream(fileName);
    try {
        byte[] bytes = new byte[8192];
        int left = in.readInt();
        int len;
        while(left > 0 && (len = in.read(bytes, 0, Math.min(left, bytes.length))) > 0) {
            fos.write(bytes, 0, len);
            left -= len;
        }
    } finally {
        fos.close();
    }
}