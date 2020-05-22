public Flux<String> timeOutWithRetry(Flux<String> colors) {
    return colors.concatMap(
            color -> simulateRemoteCall(color)
                        .timeout(Duration.ofMillis(400))
                        .retry(2)
                        .onErrorReturn("default"));
}