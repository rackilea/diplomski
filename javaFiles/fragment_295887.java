Observable.create((ObservableEmitter<String> s) -> s.onError(new RuntimeException("always fails")))
        .retry(3)
        .onErrorResumeNext(throwable -> {
            return Observable.just("hi");
        })
        .subscribe(System.out::println, System.out::println);