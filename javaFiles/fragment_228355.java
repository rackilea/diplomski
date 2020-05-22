drawableObservable
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(new Subscriber<Drawable>() {
        @Override
        public void onCompleted() {   
        }

        @Override
        public void onError(Throwable e) {
        }

        @Override
        public void onNext(Drawable drawable) {
        }
});