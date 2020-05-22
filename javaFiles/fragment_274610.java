ConnectableObservable<String> o = Observable.create(emitter -> {
    try (BufferedReader reader = ...) {
        while (!emitter.isDisposed()) {
            String line = reader.readLine();
            if (line == null || line.equals("end")) {
                emitter.onComplete();
                return;          
            }
            emitter.onNext(line);
        }
    }
}).subscribeOn(Schedulers.io())
  .publish();

o.subscribe(/* consumer 1 */);
o.subscribe(/* consumer 2 */);

o.connect();