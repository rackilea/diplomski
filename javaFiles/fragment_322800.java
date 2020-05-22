ExecutorService executorService = Executors.newFixedThreadPool(10);

    List<Future<?>> futures = IntStream.rangeClosed(1, 10000)
                                       .mapToObj(i -> {
                                           return executorService.submit(() -> {
                                               try {
                                                   System.out.println(kur(i));
                                               } catch (Exception e) {
                                                   // do something useful here - remember you're in a separate thread
                                                   //
                                                   // this is not useful.
                                                   e.printStackTrace();
                                               }
                                           });
                                       })
                                       .collect(Collectors.toList());

    for (Future<?> f : futures) {
        f.get();
    }

    executorService.shutdown();
    executorService.awaitTermination(1, TimeUnit.MINUTES);