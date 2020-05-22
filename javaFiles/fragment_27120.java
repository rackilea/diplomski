completableFuture.thenAccept(new Consumer<Object>() {
        @Override
        public void accept(Object object) {
            response.resume(object);
        }
    });