Observable.<MyObject>create(emitter -> {

    // Some async code

    emitter.setDisposable(Disposables.fromRunnable(() -> {
        // Stop the above async code
    }));
})
.take(5, TimeUnit.SECONDS);