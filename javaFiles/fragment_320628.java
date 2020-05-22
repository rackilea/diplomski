CompletableFuture.supplyAsync(()->{
        System.out.println(Thread.currentThread().getName());
        return "SupplyAsync";
    }).thenAccept(i->{
    System.out.println(Thread.currentThread().getName()+"--"+i);
    });