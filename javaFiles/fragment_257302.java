InputStream stream = sftp.get("/some/file");
try {
    BufferedReader br = new BufferedReader(new InputStreamReader(stream));
    // read from br
} finally {
    stream.close();
}