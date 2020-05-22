Observable
            .just(1, 2, 3)
            .flatMap(Observable::just)
            .subscribe(MeasuringSubscriber.measuringSubscriber(
                    System.out::println,
                    System.out::println,
                    System.out::println
            ));