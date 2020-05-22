File file = new File(servletContext.getRealPath("/foo.xhtml"));

if (!file.exists()) {
    OutputStream output = new FileOutputStream(file);

    try {
        output.write(bytes); // Can be bytes from DB.
    } finally {
        output.close();
    }
}