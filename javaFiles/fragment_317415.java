private static String readLogFile(String path) throws IOException {
    File f = new File(path);
    if(f.exists()) {
        FileInputStream fis = new FileInputStream(f);
        Integer fileLength = (int) (long) f.length();
        byte[] b = new byte[fileLength];
        int read = 0;
        while (read < b.length) {
            read += fis.read(b, read, b.length - read);
        }
        String text = new String(b);
        return text;
    } else {
        String text = "";
        return text;
    }
}