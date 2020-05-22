private long fileLength;
    private long totalBytes;

    private final ListenableInputStream.ReadListener readListener = new ListenableInputStream.ReadListener() {
        @Override
        public void onRead(long bytes) {
            totalBytes += bytes;
            publishProgress(totalBytes);
        }
    };