static String readFile(String file) throws IOException {
    try(FileInputStream fis = new FileInputStream(file)) {
         byte[] bytes = new byte[(int) fis.available()];
         fis.read(bytes);
         return new String(bytes);
    }
}