public static void gridSearch(/*Dataset ds*/)
{
    double bestAcc = 0;

    int cores = Runtime.getRuntime().availableProcessors();
    executor = Executors.newFixedThreadPool(cores);

    for (int i = -5; i < 15; i++) {

        double param1 = Math.pow(2, i);

        for (int j = -15; j < 3; j++) { 

            double param2 = Math.pow(2, j);  

            Runnable worker = new WorkerThread(param1, param2);
            futures.add(executor.submit(worker));
        }
    }

    System.out.println("Waiting for all threads to terminate ..");

    // Joining all threads in order to wait for all to finish
    // before returning from gridSearch()
    for (Future future: futures) {
        try {
            future.get(100, TimeUnit.SECONDS); 
        } catch (Throwable cause) {
            // process cause
        }
    }

    System.out.println("Printing results ..");

    for(CVResult result : resultList) {
        System.out.println("Acc: " + result.accuracy + 
                " for param1: " + result.param1 + 
                " | param2: " + result.param2);
    }
}