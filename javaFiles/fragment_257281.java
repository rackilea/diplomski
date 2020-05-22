private Optional<String> doSomethingWithRetry() {
        RetryPolicy<Optional> retryPolicy = new RetryPolicy<Optional>()
                .withMaxAttempts(3)
                .handleResultIf(result -> {
                    System.out.println("predicate");
                    return !result.isPresent();
                });

        return Failsafe
                .with(retryPolicy)
                .onSuccess(response -> System.out.println("ok"))
                .onFailure(response -> System.out.println("no ok"))
                .get(() -> doSomething());
    }

    private Optional<String> doSomething() {
         return Optional.of("result");
    }