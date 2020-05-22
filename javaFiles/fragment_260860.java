return colors
            .timeout(Duration.ofMillis(400))
            //.timeout(Duration.ofMillis(400), Mono.just("default"))
            .retry(2)
            .flatMap(this::simulateRemoteCall)
            .onErrorReturn(TimeoutException.class, "default");