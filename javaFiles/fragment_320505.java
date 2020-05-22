InputStream input = null;
try {
    input = new FileInputStream(...);
    input = new BufferedInputStream(input);
    input = new ZipInputStream(input);
    ZipInputStream zin = (ZipInputStream) input;
    // work here
} finally {
     if (input != null)
         try { input.close(); } catch (IOException ignored) {}
}