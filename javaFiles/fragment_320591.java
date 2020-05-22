@Override
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Part filePart = req.getPart("content"); /*Get file from jsp*/

    /*Get file name of file from jsp*/
    String name = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
    GcsFileOptions instance = GcsFileOptions.getDefaultInstance();
    GcsFilename fileName = new GcsFilename(BUCKET_NAME, name);
    GcsOutputChannel outputChannel;
    outputChannel = gcsService.createOrReplace(fileName, instance);

    /*Pass the file to copy function, wich uploads the file to cloud*/
    copy(filePart.getInputStream(), Channels.newOutputStream(outputChannel));
    req.getRequestDispatcher("download.jsp").forward(req, resp);
}

private GcsFilename getFileName(HttpServletRequest req) {
    String[] splits = req.getRequestURI().split("/", 4);
    if (!splits[0].equals("") || !splits[1].equals("gcs")) {
        throw new IllegalArgumentException("The URL is not formed as expected. " +
            "Expecting /gcs/<bucket>/<object>");
    }
    return new GcsFilename(splits[2], splits[3]);
}

private void copy(InputStream input, OutputStream output) throws IOException {
    try {
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = input.read(buffer);
        while (bytesRead != -1) {
            output.write(buffer, 0, bytesRead);
            bytesRead = input.read(buffer);
        }
    } finally {
        input.close();
        output.close();
    }
}