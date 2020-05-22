.retryWhen(throwableObservable ->
                                throwableObservable.flatMap(throwable -> {
                                    if (throwable instanceof IllegalArgumentException) {
                                        System.out.println("Retry on error: " + throwable);
                                        return Observable.just(1);
                                    } else {
                                        System.out.println("Error: " + throwable);
                                        return Observable.<Integer>error(throwable);
                                    }
                                })
                )