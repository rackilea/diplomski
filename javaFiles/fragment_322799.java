ExecutorService executorService = Executors.newFixedThreadPool(10);

IntStream.rangeClosed(1, 10000)
         .forEach(i -> {
             executorService.submit(() -> {
                 try {
                     System.out.println(kur(i));
                 } catch (Exception e) {
                     // do something useful here - remember you're in a separate thread
                     //
                     // this is not useful.
                     e.printStackTrace();
                 }
             });
         });

executorService.shutdown();
executorService.awaitTermination(1, TimeUnit.MINUTES);