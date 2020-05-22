API.getVideoListObservable()
    .map(r -> r.getObjects())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(videos -> {
        // do stuff with videos
        fragment.updateVideoList(videos);
        kalturaVideoList.addAll(videos);
    }, throwable -> {
        // handle errors
        throwable.printStackTrace();
    });