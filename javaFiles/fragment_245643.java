Flowable.generate(emitter -> {
    String line = resource.readLine();
    if (line == null) {
        emitter.onComplete();
    } else {
        emitter.onNext(line);
    }
});