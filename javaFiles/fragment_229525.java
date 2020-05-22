OutputStream output = null;
try {
    output = new FileOutputStream(file);
    // ...
} finally {
    if (output != null) try { output.close(); } catch (IOException logOrIgnore) {}
}