AppDatabase.getAppDatabase(getActivity()).deviceDao().getAllDevices()
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe((Consumer<Subscription>) subscription -> {
                    // do something when subscribe
                    // show progress here
                })
                .doOnTerminate((Action) () -> {
                    // do something when success or fail
                    // hide progress here
                })
                .subscribe(device -> {
                    // load data success
                }, throwable -> {
                    // do when error
                });