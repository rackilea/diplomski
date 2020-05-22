UploadThread ut = new UploadThread(...);
ut.addUploadListener(new UploadListener() {
    public void uploadComplete() {
        System.out.println("Upload completed.");
    }
});

ut.start();