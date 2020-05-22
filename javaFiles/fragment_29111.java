private Observable<...> getData() {
        return dataStore.getData()
              .doOnNext(...)
              .map(...)
              .doOnSubscribe(() -> myBoolean = true)
              .doAfterTerminate(() -> myBoolean = false)
              .map(...)
      }

    Subscription mySub = getData()
            .observeOn(AndroidSchedulers.mainThread(), true)
            .subscribe(onNextDoSomethingWithABoolean,
               onErrorDoSomethingWithABoolean);