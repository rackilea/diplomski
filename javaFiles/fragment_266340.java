// this is the main thread so waiting for solutions in a while(true) loop is ok
while (true) {
    // are all the workers done?
    if (pool.isTerminated()) {
       // if there are results process one last time
       if (!solutions_results.isEmpty()) {
           processTheSolutions();
       }
       break;
    } else {
        if (solutions_results.isEmpty()) {
            // wait a bit to not spin, you could also use a wait/notify here
            Thread.sleep(1000);
        } else {
            processTheSolutions();
        }
    }
}