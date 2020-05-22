// Create a scheduler (1 thread in this example)
final ScheduledExecutorService scheduledExecutorService = 
        Executors.newSingleThreadScheduledExecutor();

// Setup the parameters for your method
final String url = ...;
final String word = ...;

// Schedule the whole thing. Provide a Runnable and an interval
scheduledExecutorService.scheduleAtFixedRate(
        new Runnable() {
            @Override
            public void run() {

                // Invoke your method
                PublicPage(url, word);
            }
        }, 
        0,   // How long before the first invocation
        10,  // How long between invocations
        TimeUnit.MINUTES); // Time unit