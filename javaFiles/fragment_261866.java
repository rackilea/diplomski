public byte[] getDigitValues(String file) throws IOException {
    FileReader rdr = new FileReader(file);
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    try {
        rdr = new BufferedReader(rdr);
        for (char c = rdr.read(); c != -1; c = rdr.read()) {
            if (c >= '0' && c <= '9') {
                bos.write(c - '0');
            }
        }
    } finally {
        if (rdr != null) {
            try { rdr.close(); }
            catch (IOException e) {
                throw new IOException("Could not close file", e);
            }
        }
    }
    return bos.toByteArray();
}