Reader reader = null;
Writer writer = null;

try {
    reader = new InputStreamReader(new FileInputStream(cssFile), "UTF-8");
    writer = new OutputStreamWriter(new FileOutputStream(minFile), "UTF-8");
    new CssCompressor(reader).compress(writer, -1); // That's it.
} finally {
    close(writer);
    close(reader);
}