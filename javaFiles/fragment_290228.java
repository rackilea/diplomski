CompletableFuture<String> supply = CompletableFuture.supplyAsync(() -> {
        System.out.println("Hello");
        return "result";
    });

 System.out.println(supply.get());  //result