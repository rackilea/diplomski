final String ENCODING = "UTF-8";
PrintWriter out = new PrintWriter(file, ENCODING))));
try {
    out.print("\ufffe"); // Write the BOM
    out.println("<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>");
    ...
} finally {
    out.close();
}