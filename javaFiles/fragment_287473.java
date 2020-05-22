Observable<Long> observable1 = Observable.interval(3, 1000, TimeUnit.MILLISECONDS);
observable1.subscribe(l -> System.out.println(l));

try {
    Thread.sleep(5000);
}
catch(InterruptedException e) { }