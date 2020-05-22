public static void main(String[] args) {
    HttpExchange exchange = ...;
    OutputStream responseBody = null;

    try {
        File file = new File("big-file.txt");
        long bytesToSkip = 4711; //detemine how many bytes to skip

        exchange.sendResponseHeaders(200, file.length() - bytesToSkip);
        responseBody = exchange.getResponseBody();
        skipAndCopy(file, responseBody, bytesToSkip);           
    }
    catch (IOException e) {
        // handle it
    }
    finally {
        IOUtils.closeQuietly(responseBody);
    }
}


private static void skipAndCopy(File src, @WillNotClose OutputStream dest, long bytesToSkip) throws IOException {
    InputStream in = null;

    try {
        in = FileUtils.openInputStream(src);

        IOUtils.skip(in, bytesToSkip);
        IOUtils.copyLarge(in, dest);
    }
    finally {
        IOUtils.closeQuietly(in);
    }
}