public Observable<Joke> getAllJokes() {

    Observable<Joke> remote = mRepository.getAllJokes()
            .subscribeOn(Schedulers.io());


    Observable<Joke> local = mRepository.getAllJokes().subscribeOn(Schedulers.io());

      return Observable.mergeDelayError(local, remote).filter(joke -> joke != null);
}