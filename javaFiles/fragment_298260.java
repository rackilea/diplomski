void aMethod() throws IOException {
    try {
        Files.copy(srcePath, trgtPath); // throws IOException
    }
    catch(Exception ex) {
        throw ex;
    }
}