public String readFile(String filepath) throws IOException {
    File f = new File(filepath);
    FileInputStream in = new FileInputStream(f);
    int size = in.available();
    byte c[] = new byte[size];
    for (int i = 0; i < size; i++) {
        c[i] = (byte) in.read();
    }
    String filedata = new String(c, "utf-8");
    return filedata;
}