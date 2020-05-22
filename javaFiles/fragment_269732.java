Observable.zip(getObservable1()),//remote Data
        getObservable2(), // local Data
        (observableResult1,observableResult2)->{
            doSomethingWith(observableResult1,observableResult2); // compare between data

            return CheckStatus.SUCCESS;   // <-- CHANGES

        }).subscribeOn(BackgroundSchedulers.getMultiThreadInstance())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnCompleted(() -> {
                doSomething2(); // update fields
            }
        });