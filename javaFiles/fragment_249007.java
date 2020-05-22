observable.onErrorResumeNext(error -> {
              if(errorOk)
                  return Observable.just(ok)
              else
                  return Observable.error(error)
          })
          .subscribeOn(Schedulers.io())
          .observeOn(Schedulers.trampoline())
          .subscribe(item -> onNextAction(),
              error -> onErrorAction()
          );