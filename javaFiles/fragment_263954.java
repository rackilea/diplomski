CompletableFuture.runAsync(() -> {
        //some code here...
        System.out.println("Hi!");
    }).thenRun(() -> {
        //some code here
        System.out.println("Greeting completed");
    });