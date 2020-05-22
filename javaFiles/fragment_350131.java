Observable.from(items)
            .flatMap(item -> {
                item.content().put("age", 42);
                return bucket.async()
                        .replace(item)
                        .retry((count, throwable) -> count == 1 && throwable instanceof CASMismatchException)
                        .onErrorReturn(e -> {
                            errorHandler.handleError(item.id(), e);
                            return null; //or item, if you need the item further down the stream
                        })
                        .subscribeOn(Schedulers.io()); //not sure if it's needed with bucket.async()
            })
            .subscribeOn(<something>) //with this scheduler the put() method will be executed 
            .subscribe();