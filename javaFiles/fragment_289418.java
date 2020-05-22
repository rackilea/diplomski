static <T> SingleTransformer<T, T> subscribeAndFinalTransformer() {
        return new SingleTransformer<T, T>() {
            @Override
            public SingleSource<T> apply(Single<T> upstream) {
                return upstream.doOnSubscribe(disposable -> {
                    // Your doOnSubscribe Block
                }).doFinally(() -> {
                    // Your doFinally Block 
                });
            }
        };
    }