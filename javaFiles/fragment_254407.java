myRetrofit.makeHttpCall(url)
                    .subscribeOn(Schedulers.io())
                    .map(Response::code)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            i -> Timber.d("code " + i),
                            e -> {
                                if (!(e instanceof EOFException)) {
                                    Timber.e(e, "error occurred");
                                }
                            });