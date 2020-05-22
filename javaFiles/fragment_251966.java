// NetworkRepository.java
public Observable<Data> getData() {
    // implementation
}

// DiskRepository.java
public Observable<Data> getData() {
    // implementation
}

// DiskRepository.java
public void saveData(Data data) {
    // implementation
}

// DomainService.java
public Observable<Data> getMergedData() {
  return Observable.merge(
    diskRepository.getData().subscribeOn(Schedulers.io()),
    networkRepository.getData()
      .doOnNext(new Action1<Data>() { 
        @Override 
        public void call(Data data) { 
          diskRepository.saveData(data); // <-- save to cache
        } 
      }).subscribeOn(Schedulers.io())
  );
}