BackoffStrategy backoffStrategy = new BaseBackoffStrategy();
List<CharSequence> observableList = Arrays.asList("a");

Observable.from(observableList)
        .flatMap(charSequence -> {
            if (charSequence.length() == 1) {
                return Observable.error(new RuntimeException("Too short"));
            } else {
                return Observable.just(charSequence);
            }
        })
        .retryWhen(observable ->
                observable
                        .filter(backoffStrategy::isApplicable)
                        .doOnNext(next -> System.out.println("Appropriate throwable is thrown!"))
                        .zipWith(Observable.range(1, 3 + 1), Tuple::new)
                        .flatMap(tuple -> {
                            Integer attempts = tuple.getRight();
                            if (attempts <= 3) {
                                System.out.println(new Date().toGMTString() + " : " + attempts + " retry");
                                return Observable.timer((long) Math.pow(2, attempts), TimeUnit.SECONDS);
                            } else {
                                return Observable.error(tuple.getLeft());
                            }
                        })
        )
        .toBlocking()
        .subscribe(
                next -> System.out.println("Next: " + next),
                error -> System.out.println("Error: " + error),
                () -> System.out.println("Completed")
        );