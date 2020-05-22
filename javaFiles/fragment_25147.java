class TestViewModel extends ViewModel {

    private LiveData<String> countdown;

    LiveData<String> getCountdown() {
        if (countdown == null) {
            countdown = LiveDataReactiveStreams.fromPublisher(startCountdown());
        }
        return countdown;
    }

    private static Flowable<String> startCountdown() {
        final BehaviorProcessor<String> processor = BehaviorProcessor.create();
        Flowable.concat(
                Flowable.just("Falcon Heavy rocket will launch in..."),
                Flowable.intervalRange(0, 10, 3, 1, TimeUnit.SECONDS)
                        .map(x -> String.valueOf(10 - x)),
                Flowable.timer(1, TimeUnit.SECONDS)
                        .map(ignored -> "Lift off!")
        ).subscribe(processor);
        return processor;
    }
}