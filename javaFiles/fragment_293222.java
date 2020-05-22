InputStream is = null;
try {
    is = new FileInputStream(someFile);
    // read the stream
} finally {
    if (is != null) {
        is.close();
    }
}