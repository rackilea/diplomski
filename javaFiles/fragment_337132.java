XMLInputFactory factory = XMLInputFactory.newInstance();
InputStream in = fs.open(file);
final long fileSize = someHadoopService.getFileLength(file);
InputStremListener listener = new InputStreamListener() {
    public void onBytesRead(long totalBytes) {
        System.out.println(String.format("Read %s of %s bytes", totalBytes, fileSize));
    }
};
InputStream publishingIn = new PublishingInputStream(in, listener);
try {
    reader = factory.createXMLStreamReader(publishingIn);
    // etc