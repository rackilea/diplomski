}).retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>(){
@Override
public Observable<?> call(Observable<? extends Throwable> o) {
    final AtomicInteger count = new AtomicInteger();
    return o.filter(new Func1<Throwable, Boolean>() {
        @Override
        public Boolean call(Throwable t) {
            return t instanceof RuntimeException || count.getAndIncrement() < 5;
        }}).delay(1, TimeUnit.SECONDS, Schedulers.immediate());
}})