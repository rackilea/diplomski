public String[] loadText(String resName) throws IOException {
    String[] text;
    InputStream in = getClass().getResourceAsStream(resName);
    try {
        DataInputStream din = new DataInputStream(in);
        int size = din.readShort();
        text = new String[size];
        for (int i = 0; i < size; i++) {
            text[i] = din.readUTF();
        }
    } finally {
        in.close();
    }
    return text;
}