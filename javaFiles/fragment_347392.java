InputStream is = null;
try {
    is = new FileInputStream(...);
    // do stuff
} catch (IOException e) {
    // do stuff
} finally {
    if (is != null) {
        is.close();
    }
}