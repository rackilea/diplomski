private Observable<List<Video>> getVideos() {
    return API.getVideoListObservable()
        .map(r -> r.getObjects());
}

// in onCreate()
RxLoaderManager loaderManager = RxLoaderManager.get(this);
RxLoader<List<Video>> videoLoader = loaderManager.create(
    getVideos().observeOn(AndroidSchedulers.mainThread()),
    new RxLoaderObserver<List<Video>>() {
        @Override
        public void onNext(List<Video> videos) {
            // do stuff with videos
            fragment.updateVideoList(videos);
            kalturaVideoList.addAll(videos);
        }

        @Override
        public void onError(Throwable throwable) {
            // handle errors
            throwable.printStackTrace();
        }
    });

// whenever you need to update videos
videoLoader.restart();