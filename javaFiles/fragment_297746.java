ExecutorService executorService = Executors.newFixedThreadPool(8);
CompletableFuture feature = CompletableFuture.supplyAsync(() -> {
        System.out.println("Thread : " + Thread.currentThread());
        System.out.println("Is Daemon : " + Thread.currentThread().isDaemon());
        return composeMethod();
    }, executorService).thenAccept(s -> System.out.println("wassup java" + s))
            .thenRun(() -> System.out.println(" imm immortal"));
executorService.shutdown();
nonblockingmethod();