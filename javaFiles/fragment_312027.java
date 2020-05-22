Observable<String> pLanguages = Observable.create(emitter -> {
    emitter.onNext("Kotlin");
    emitter.onNext("Java");
    emitter.onNext("Python");
    emitter.onNext("Javascript");
    emitter.onNext("Go");
    emitter.onNext("C");
    emitter.onNext("Rust");
    emitter.onComplete();
});