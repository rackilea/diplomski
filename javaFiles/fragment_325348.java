CompletableFuture completableFuture = new CompletableFuture();
    completableFuture.whenComplete(new BiConsumer() {
        @Override
        public void accept(Object o, Object o2) {
            //handle complete
        }
    }); // complete the task
    completableFuture.complete(new Object())