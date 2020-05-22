int writeThreads = 3;
int genThreads = 10;
int guidPerThread = 200_000;
try (S3UploadStream uploadStream = new S3UploadStream(s3client, "<YourBucket>", "<YourKey>.gz", writeThreads)) {
    try (GZIPOutputStream stream = new GZIPOutputStream(uploadStream)) {
        Semaphore s = new Semaphore(0);
        for (int t = 0; t < genThreads; ++t) {
            new Thread(() -> {
                for (int i = 0; i < guidPerThread; ++i) {
                    try {
                        stream.write(java.util.UUID.randomUUID().toString().getBytes());
                        stream.write('\n');
                    } catch (IOException e) {
                    }
                }
                s.release();
            }).start();
        }
        s.acquire(genThreads);
    }
}