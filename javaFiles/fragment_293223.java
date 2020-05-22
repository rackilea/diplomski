InputStream is = null;
try {
    is = new FileInputStream(someFile);
} finally {
    if (is != null) {
        is.close();
    }
}
// read the stream ... OOOPS!  We've already closed it!!