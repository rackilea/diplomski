Observable.range(1, 10_000)
        .nest()
        .flatMap(
                o -> {
                    Observable<Integer> pipelineToMeasure = o.flatMap(i -> {
                        Random random = new Random(73);
                        try {
                            TimeUnit.MILLISECONDS.sleep(random.nextInt(5));
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        return Observable.just(i);
                    });

                    Stopwatch measure = Stopwatch.createUnstarted();
                    return pipelineToMeasure
                            .doOnSubscribe(measure::start)
                            .doOnTerminate(() -> {
                                measure.stop();
                                System.out.println(measure);
                            });
                }
        )
        .toBlocking()
        .forEach(System.out::println);