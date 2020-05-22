InternetUtil.isInternetOn()
            .flatMap((new Func1<Boolean, Observable<UserProfile>>() {
                @Override
                public Observable<UserProfile> call(boolean isOn) {
                    if (isOn){
                        return Observable.fromCallable((Callable<ObservableSource<?>>) () -> baseDataManager.signIn(requestBody));
                    } else {
                        return Obserable.error(new Throwable("no internet"));
                    }
                }
            })
            .retryWhen()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()