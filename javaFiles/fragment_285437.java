public static void main(String[] args) throws IOException {
    byte[] buffer = new byte[2048];
    while (true) {
        int len = System.in.read(buffer);
        if (len <= 0) {
            break;
        }
        for (int i = 0; i < len; i++) {
            ...
        }
        System.out.write(buffer, 0, len);
    }
}