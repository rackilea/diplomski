public void writeToFile(String path, byte[] key) throws IOException {
    File f = new File(path);
    f.getParentFile().mkdirs();

    StringBuilder sb = new StringBuilder();
    for(byte b: key) {
        sb.append(String.format("%02X", b) + " ");
    }

    try (FileWriter fos = new FileWriter(f)) {
        fos.write(sb.toString());
        fos.flush();
    }
}