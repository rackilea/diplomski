interface Observable<T> {
    Disposable subscribe(Observer<T> observer);
}

interface Observer<T> {
   void onCompleted();
   void onError(Exception error);
   void onNext(T value);
}