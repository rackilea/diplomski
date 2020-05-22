public static String fileToString(String filename) throws Exception {
    FileInputStream fis = new FileInputStream(filename);
    byte[] buffer = new byte[8192];
    StringBuffer sb = new StringBuffer();   
    int bytesRead; // unused? weird compiler messages...
    while((bytesRead = fis.read(buffer)) != -1) { // InputStream.read() returns -1 at EOF
        sb.append(new String(buffer,0,bytesRead));
        buffer = new byte[8192];
        bytesRead=0;
    }
    return new String(sb);
}