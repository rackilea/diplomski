private static byte[] readUTFHeaderBytes(File input) throws IOException {
    FileInputStream fileInputStream = new FileInputStream(input);
    try{
        byte firstBytes[] = new byte[4];
        int count = fileInputStream.read(firstBytes);
        if(count < 4){
            throw new IOException("Empty file");
        }
        return firstBytes;
    } finally {
        fileInputStream.close();
    }
}