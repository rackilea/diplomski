@Test
public void test()
{
    System.out.println("Executing test on thread ID: " + Thread.currentThread().getId());
    final BehaviorSubject<Integer> rotorBehaviour = BehaviorSubject.create();
    Observable<Integer>rotorObservable = rotorBehaviour.observeOn(Schedulers.single());

    rotorObservable.subscribe(new Observer<Integer>()
    {
        @Override
        public void onSubscribe(final Disposable d)
        {
            System.out.println("onSubscribe() called on thread ID: " + Thread.currentThread().getId());
        }

        @Override
        public void onNext(final Integer integer)
        {
            System.out.println("onNext() called on thread ID: " + Thread.currentThread().getId());
        }

        @Override
        public void onError(final Throwable e)
        {
            System.out.println("onError() called on thread ID: " + Thread.currentThread().getId());
        }

        @Override
        public void onComplete()
        {
            System.out.println("onComplete() called on thread ID: " + Thread.currentThread().getId());
        }
    });
    rotorBehaviour.onNext(1);
    rotorBehaviour.onNext(2);
}