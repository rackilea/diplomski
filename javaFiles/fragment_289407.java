public class SubmissionPubliserDropTest {

    public static void main(String[] args) throws InterruptedException {
        // Create Publisher for expected items Strings
        // Note the small buffer max capacity to be able to cause drops
        SubmissionPublisher<String> publisher =
                               new SubmissionPublisher<>(ForkJoinPool.commonPool(), 2);
        // Register Subscriber
        publisher.subscribe(new CustomSubscriber<>());
        publisher.subscribe(new CustomSubscriber<>());
        publisher.subscribe(new CustomSubscriber<>());
        // publish 3 items for each subscriber
        for(int i = 0; i < 3; i++) {
            int result = publisher.offer("item" + i, (subscriber, value) -> {
                // sleep for a small period before deciding whether to retry or not
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return false;  // you can switch to true to see that drops are reduced
            });
            // show the number of dropped items
            if(result < 0) {
                System.err.println("dropped: " + result);
            }
        }
        Thread.sleep(3000);
        publisher.close();
    }
}

class CustomSubscriber<T> implements Flow.Subscriber<T> {

    private Subscription sub;

    @Override
    public void onComplete() {
        System.out.println("onComplete");
    }

    @Override
    public void onError(Throwable th) {
        th.printStackTrace();
        sub.cancel();
    }

    @Override
    public void onNext(T arg0) {
        System.out.println("Got : " + arg0 + " --> onNext() callback");
        sub.request(1);
    }

    @Override
    public void onSubscribe(Subscription sub) {
        System.out.println("Subscription done");
        this.sub = sub;
        sub.request(1);
    }

}