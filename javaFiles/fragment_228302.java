ExecutorService service = Executors.newFixedThreadPool(3);
service.submit(matrixMult1);
service.submit(matrixMult2); // the objects that do the work
service.submit(matrixMult3);

service.shutdown();
service.awaitTermination(1, TimeUnit.HOURS);