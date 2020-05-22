Executor exec = Executors.newFixedThreadPool(maxActive);//15 threads
   List<CompletableFuture<Void>> futures= new ArrayList<>();

   for (UrlRequest request : urlRequests) {
            if (!validateRequests.isWhitelisted(request)) {
                futures.add(CompletableFuture.runAsync(()->ContentDetectionClient.detectContent(request), exec));
            }
        }
 CompletableFuture.allOf(futures.toArray())
                      .join();