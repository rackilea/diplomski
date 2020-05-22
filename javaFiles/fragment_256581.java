Observable.just(new Object())
            .doOnNext(o -> { /* /* This method catches the on next but doesn't consume it. */})
            .doOnComplete(() -> { /* test */})
            .doOnError(throwable -> {/* This method catches the error but doesn't consume it. */})
            .subscribe(
                    new DefaultObserver<Object>() {
                        @Override
                        public void onNext(Object o) {

                        }

                        @Override
                        public void onError(Throwable e) {
                          // here error will be consumed at the end
                        }

                        @Override
                        public void onComplete() {

                        }
                    }
            );