try {
    zin = new ZipInputStream(new BufferedInputStream(new FileInputStream(file)));
    // Work with the entries...
    // Exception handling
} finally {
    if (zin!=null) { try {zin.close();} catch (IOException ignored) {} }
}