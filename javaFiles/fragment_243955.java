MeasurableAction1<Integer> measuring = MeasurableAction1.measure(System.out::println);
Observable
        .just(1, 2, 3)
        .flatMap(Observable::just)
        .toBlocking()
        .forEach(measuring.start());

measuring.stop().elapsed(TimeUnit.SECONDS);