Subscriber sub1=new Subscriber<Integer>() {
        Subscription subscription;

        @Override
        public void onSubscribe(Subscription s) {
            this.subscription = s;
            s.request(1);
            System.out.println("onSubscribe done");
        }

        @Override
        public void onNext(Integer t) {
            System.out.println("Sub 1 Processing: "+t);
            sleep(1000);
            subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) { }

        @Override
        public void onComplete() { }
    };

    Subscriber sub2=new Subscriber<Integer>() {
        Subscription subscription;

        @Override
        public void onSubscribe(Subscription s) {
            this.subscription = s;
            s.request(1);
            System.out.println("onSubscribe done");
        }

        @Override
        public void onNext(Integer t) {
            System.out.println("Sub2 Processing: "+t);
            sleep(500);
            subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) { }

        @Override
        public void onComplete() { }
    };

    // ***** Magic happens here!! *****
    DispatchWorkProcessor<Integer> dwp = DispatchWorkProcessor.create(Schedulers.io());
    Flowable.range(1, 20).subscribe(dwp);
    dwp.subscribe(sub1);
    dwp.subscribe(sub2);
    // ********************************

    sleep(Integer.MAX_VALUE);
}