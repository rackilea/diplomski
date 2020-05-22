import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class DemoRxJava2 {

    public static void testWithQueue() {

        CompletableFuture<String> allDone = new CompletableFuture<>();
        AtomicBoolean submitDone = new AtomicBoolean(Boolean.FALSE);
        final Queue<Long> queue = new ConcurrentLinkedQueue<>();

        Observable.interval(2, TimeUnit.SECONDS)
        .takeWhile(tick -> !queue.isEmpty() || !submitDone.get())
        .flatMap(tick -> {
            return Observable.create(sub -> {
                while (!queue.isEmpty()) {
                    sub.onNext(queue.poll());
                }
                sub.onComplete();
            });
        })
        .subscribeOn(Schedulers.single())
        .doOnSubscribe(dis -> System.out.println("Queue processing active"))
        .doOnComplete(() -> {
            System.out.println("Queue processing done");
            allDone.complete("DONE");
        })
        .subscribe(nextTs -> System.out.printf("[%s] : Processing tx : %d\n", Thread.currentThread().getName(), nextTs));

        Observable.interval(1,TimeUnit.SECONDS)
        .take(10)
        .doOnSubscribe(dis -> System.out.println("Job submitter start"))
        .doOnNext(tick -> {
            long ms = System.currentTimeMillis() / 1000;
            System.out.printf("[%s] : Submitting tx : %d\n", Thread.currentThread().getName(), ms);
            queue.add(ms);
        })
        .doOnComplete(() -> submitDone.set(Boolean.TRUE))
        .blockingSubscribe();

        try {
            allDone.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void testWithSubject() {

        CompletableFuture<String> allDone = new CompletableFuture<>();

        PublishSubject<Long> queue = PublishSubject.create();

        queue.observeOn(Schedulers.single())
        .flatMap(tx -> Observable.just(tx).delay(2, TimeUnit.SECONDS))
        .doOnSubscribe(dis -> System.out.println("Queue processing active"))
        .doOnComplete(() -> allDone.complete("DONE"))
        .subscribe(nextTs -> System.out.printf("[%s] : Processing tx : %d\n", Thread.currentThread().getName(), nextTs));

        Observable.interval(1, TimeUnit.SECONDS)
        .take(10)
        .doOnSubscribe(dis -> System.out.println("Job submitter start"))
        .doOnNext(tick -> {
            long ms = System.currentTimeMillis() / 1000;
            System.out.printf("[%s] : Submitting tx : %d\n", Thread.currentThread().getName(), ms);
            queue.onNext(ms);
        })
        .doOnComplete(() -> queue.onComplete())
        .blockingSubscribe();

        //wait until all done
        try {
            allDone.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testWithQueue();
        testWithSubject();
    }
}