public static Observable<KalturaVideo> getVideoList(Context context, String kalturaPlaylistId){
    return Observable.create(new Observable.OnSubscribe<KalturaVideo>()     {
        @Override
        public void call(Subscriber<? super KalturaVideo> subscriber) {
            getKalturaPlaylistContentObservable(kalturaPlaylistId, context)
                    .flatMap(new Func1<String[], Observable<?>>() {
                        @Override
                        public Observable<?> call(String[] videoIdList) {
                            return getKalturaVideoListObservable(context, videoIdList)
                                    .doOnNext(kalturaVideo -> {
                                        subscriber.onNext(kalturaVideo);
                                    })
                                    .doOnCompleted(() -> subscriber.onCompleted());
                        }
                    })
                    .subscribe();
        }
    });
}