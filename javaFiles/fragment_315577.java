void writeFile(String fileName, String... values) {
    File file = new File(fileName);
    file.getParentFile().mkdirs();
    boolean fileExists = file.exists();
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
        if (fileExists && !newLineExists(file)) {
            bw.newLine();
        }
        for (String value : values) {
            bw.write(value);
            bw.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

boolean newLineExists(File file) throws IOException {
    RandomAccessFile fileHandler = new RandomAccessFile(file, "r");
    long fileLength = fileHandler.length() - 1;
    if (fileLength < 0) {
        fileHandler.close();
        return true;
    }
    fileHandler.seek(fileLength);
    byte readByte = fileHandler.readByte();
    fileHandler.close();

    if (readByte == 0xA || readByte == 0xD) {
        return true;
    }
    return false;
}