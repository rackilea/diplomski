/** Basically creates to-start number of futures in a while loop, while passing the index to a Lambda that is passed and that returns a Runnable which will have access to the index. See example below. **/
   public static CompletableFuture[] async(ExecutorService executorService, int start, int to, Runnable beforeAll, Lambda.R1<Runnable, Integer> onEach, Double onPercentage, Runnable onPercentageRun, Runnable afterAll) {
            CompletableFuture[] futures = new CompletableFuture[to-start];

            double        onPercentageIndex = Valid.elvis(onPercentage, 0.0) * futures.length;  // When to onPercentageRun
            AtomicBoolean percentageMet     = new AtomicBoolean ( false );
            AtomicBoolean completeMet       = new AtomicBoolean ( false );
            AtomicInteger complete          = new AtomicInteger ( 0     );

            int i = start;
            if ( i < to && beforeAll != null ) {
                    beforeAll.run();
            }
            boolean percentageSet = onPercentageIndex > 0.0 && onPercentageRun != null;
            boolean completeSet = afterAll != null;
            while( i < to ) {

                    Runnable call = onEach.call(i);
                    futures[i-start] = CompletableFuture.runAsync(

                            () -> {
                                    try {
                                            call.run();
                                    } catch (Throwable e) {
                                            $Log.info(Concurrency.class, "RunAsync: run", e);
                                    }

                                    if ( percentageSet || completeSet ) {
                                            complete.incrementAndGet();

                                            if ( percentageSet && !percentageMet.get() && complete.get() >= onPercentageIndex) {
                                                    percentageMet.set(true);

                                                    try {
                                                            onPercentageRun.run();
                                                    }
                                                    catch(Throwable e) {
                                                            $Log.info(Concurrency.class, "RunAsync: onPercentage", e);
                                                    }
                                            }

                                            if ( completeSet && !completeMet.get() && complete.get() == to ) {
                                                    completeMet.set(true); // Just for clarity, propably redundant

                                                    try {
                                                            afterAll.run();
                                                    }
                                                    catch(Throwable e) {
                                                            $Log.info(Concurrency.class, "RunAsync: onComplete", e);
                                                    }

                                            }
                                    }

                            },

                            executorService
                    );

                    ++i;
            }

            return futures;
    }