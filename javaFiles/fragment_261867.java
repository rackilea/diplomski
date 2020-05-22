public byte[] getDigitValues(String file) throws IOException {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    try (Reader rdr = new BufferedReader(new FileReader(file))) {
        for (. . .
    }
    return bos.toByteArray();
}