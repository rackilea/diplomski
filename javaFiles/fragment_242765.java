for (int i = 0; i < threads.length; i++) {
     threads[i] = new Thread(new Runner(host, count * NUMBER_OF_PORTS_PER_THREAD));
     threads[i].start();

 }

 // Join threads after you created them
 // All credits for @biziclop for spotting this
 for (int i = 0; i < threads.length; i++) {
     threads[i].join();
 }