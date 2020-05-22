Downloader  downloader = new Downloader();

downloader.addListener(new ProgressListener(){
    public void onProgress(int n) { 
        // do something
        Thread th = new Thread(() -> downloader.addListener(() -> {});
        th.start();
        th.join();
    }
});

downloader.updateProgress(10);