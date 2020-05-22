Observable.just(retrofit.create(ApiServiceMain.class))
          .subscribeOn(Schedulers.computation())
          .flatMap(s -> {
              Observable<List<MainCategoryData>> couponsObservable
                        = s.maincategorya().subscribeOn(Schedulers.io());

              Observable<List<MainCategoryData>> storeInfoObservable
                        = s.maincategoryap().subscribeOn(Schedulers.io());

              return Observable.merge(couponsObservable,storeInfoObservable);
          })
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(this::handleRespons, this::handleError);