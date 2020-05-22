public static void main(String[] args) throws InterruptedException {

    Observable<Integer> observable2 = Observable.create(subscriber->{
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Arrays.asList(1, 2, 3).forEach((value)-> subscriber.onNext(value));
        subscriber.onCompleted();
        subscriber.onError(new RuntimeException("error"));
    });

    System.out.println("Before");

    observable2
            .subscribeOn(Schedulers.io()).subscribe(
                (next) -> log.info("Next element {}", next),
                (error) -> log.error("Got exception", error),
                () -> log.info("Finished")//on complete
    );

    System.out.println("After");
    //Thread.sleep(5000); //uncomment this to wait for subscriptions, otherwise main will quit
}