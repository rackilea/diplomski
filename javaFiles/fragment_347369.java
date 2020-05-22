Scheduler scheduler;//Main thread

Observable
                .interval(1, TimeUnit.SECONDS)
                .concatMapIterable(x -> files(file))
                .distinct()
                .observerOn(scheduler)
                .subscribe(System.out::println);