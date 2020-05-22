MyRunnable r = new MyRunnable();
 Executor exec = Executors.newFixedThreadPool(3);

 CompletableFuture<Integer> mult = CompletableFuture.runAsync(() -> r.multiply(1, 2),exec );
 CompletableFuture<Integer> add = CompletableFuture.runAsync(() -> r.add(4, 5) ,exec);
 CompletableFuture<Integer> div = CompletableFuture.runAsync(() -> r.division(10, 5),exec);

 CompletableFuture<Integer> result = mult.thenCombine(add, (multRes,addRes) -> multRes+addRest)
                                         .thenCombine(div, (total,divRes) -> total+divRes);

 int answer = result.join();