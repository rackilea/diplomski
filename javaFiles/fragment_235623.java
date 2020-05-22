private static final Subject<LogData> subject =
    PublishSubject.<LogData>create(); // .toSerialized();

private static final Disposable logProcessing =
    subject.buffer(5, TimeUnit.SECONDS)
    .subscribeWith(new DisposableObserver<List<LogData>>() {
        @Override
        public void onNext(List<LogData> logData) {
           System.out.print(logData.toString()));
        }

        @Override
        public void onError(Throwable e) {
        }

        @Override
        public void onComplete() {
        }
    });

private static void logResults(LogData logData) {
    subject.onNext(logData);
}


/**
 * This method get called every time when new log is there
 */
public static void logGenerated(LogData log) {
    logResults(log);
}