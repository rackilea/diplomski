protected void doPost(final HttpServletRequest request,
        final HttpServletResponse response) throws ServletException,
        IOException {

    // extract filename from request
    // TODO use a whitelist to avoid [path-traversing][1]
    File file = new File(getFileName(request));
    InputStream input = new FileInputStream(file);

    response.setContentLength((int) file.length());
    // TODO map your file to the appropriate MIME
    response.setContentType(getMimeType(file));

    OutputStream output = response.getOutputStream();
    byte[] bytes = new byte[BUFFER_LENGTH];
    int read = 0;
    while (read != -1) {
        read = input.read(bytes, 0, BUFFER_LENGTH);
        if (read != -1) {
            output.write(bytes, 0, read);
            output.flush();
        }
    }

    input.close();
    output.close();
}