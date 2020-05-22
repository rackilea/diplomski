public static void main(String[] args) {

    Observable.just("Hello World!", "Keep printing values!")
    .zipWith(Observable.interval(0, 5, TimeUnit.SECONDS), (a, b) -> a)
    .subscribe(v -> 
        System.out.println(Thread.currentThread() + ": " + v)
    );

    Thread.sleep(10000);  // <-----------------------------------

}