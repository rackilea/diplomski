Observable.just(new Object())
            .doOnNext(o -> { /* /* This method catches the on next but doesn't consume it. */})
            .doOnComplete(() -> { /* test */})
            .doOnError(throwable -> {/* This method catches the error but doesn't consume it. */})
            .subscribe(o ->
                    {/* success */}
                    ,
                    throwable -> {/* error */} // here error will be consumed at the end
            );