public static void main(String[] args) throws IOException {

    File file = new File("test.txt");
    // creates the file

    long len=file.length();
    System.out.println(len);


    // byte by byte:
    FileInputStream fileStream = new FileInputStream(file);
    byte[] buffer = new byte[2048];
    int read;
    while((read = fileStream.read(buffer)) != -1) {
        for(int index = 0; index < read; index++) {
            byte ch = buffer[index];
            if(buffer[index] < 0x20) {
                System.out.format(">> char: N/A, hex: %02X%n", ch);
            } else {
                System.out.format(">> char: '%c', hex: %02X%n", (char) ch, ch);
            }
        }
    }
    fileStream.close();
}