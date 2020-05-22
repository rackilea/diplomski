List<Channel> channels = ... ;
Downloader downloader = new Downloader(channels);
downloader.setOnSucceeded(e -> {
    List<Article> articles = downloader.getValue();
    // update UI with articles...
});
Thread t = new Thread(downloader);
t.setDaemon(true) ; // will not prevent application exit...
t.start();