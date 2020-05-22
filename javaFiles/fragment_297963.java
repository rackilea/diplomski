public List<Article> downloadRSS() {

    List<Article> mainList = Collections.synchronizedList(new ArrayList<>());
    CountDownLatch latch = new CountDownLatch(channels.size());

    for(Channel channel : channels){
        RSSDownloadService<List<Article>> downloader = new RSSDownloadService<List<Article>>(channel);
        downloader.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent t) {
                List<Article> result = (List<Article>)t.getSource().getValue();
                downloadHTML(result, mainList, latch);
            }
        });
        downloader.setOnFailed(t -> {
            // handle error if neccessary...
            latch.countDown();
        });
        downloader.start();
    }
    latch.await();
    // return a regular list, don't need the overhead of synchronization any more:
    return new ArrayList<>(mainList);
}

private void downloadHTML(List<Article> articles, List<Article> mainList, CountDownLatch latch){
    HTMLDownloadService<List<Article>> downloader = new HTMLDownloadService<List<Article>>(articles);
    downloader.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
        @Override
        public void handle(WorkerStateEvent t) {
            List<Article> result = (List<Article>)t.getSource().getValue();
            mainList.addAll(result);
            latch.countDown();
        }
    });

    downloader.setOnFailed(t -> {
        // handle error if needed...
        latch.countDown();
    });
    downloader.start();
}

@Override
protected Task<List<Article>> createTask() {
    return new Task<List<Article>>() {
        protected List<Article> call() {
            return downloadRSS();
        }
    };
}