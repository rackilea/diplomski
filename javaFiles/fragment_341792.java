input
                .onErrorContinue((throwable, o) -> throwable.getMessage())
                .doOnComplete(() -> { ... }
                .flatMap(bar -> Mono.subscriberContext()
                        .map(c -> Tuples.of(bar, c)))
                .doOnNext(this::defaultRealtimeEvaluator)
                .subscriberContext(Context.of("isRealtime", new AtomicBoolean()))
                .subscribe();