Completable.fromCallable(() -> {
                  Document doc = Jsoup.connect("https://en.wikipedia.org/").get();
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .unsubscribeOn(Schedulers.io());