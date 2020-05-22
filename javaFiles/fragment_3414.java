private Mono<String> readFromQueue(Integer ignore)
{
    return Mono.fromCallable(() -> {
        Thread.sleep(1500); // your actual blocking queue polling here
        return "queue_element";
    }).subscribeOn(Schedulers.elastic()); // dedicate blocking call to threadpool
}