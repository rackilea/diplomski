final int perfFor = 100000;
        d1 = new Date();
        for (int i = 0; i < perfFor; i++) {
            Channel channel1 = connection.createChannel();
            channel1.close();

        }
        d2 = new Date();
        seconds = (d2.getTime() - d1.getTime()) / 1000;
        System.out.println("Seconds-Only-CreateDestroyChannels: " + seconds);


        final AtomicInteger atomicInteger = new AtomicInteger();
        ExecutorService threadChannels = Executors.newFixedThreadPool(1000);
        final Date dThread = new Date();
        for (int i = 0; i < perfFor; i++) {

            threadChannels.submit(new Runnable() {
                public void run() {
                    Channel channel1 = null;
                    try {
                        channel1 = connection.createChannel();
                        channel1.close();
                        if (atomicInteger.addAndGet(1) == perfFor) {
                            Date d2 = new Date();
                            long seconds = (d2.getTime() - dThread.getTime()) / 1000;
                            System.out.println("Seconds-Only-CreateDestroyChannels MultiThreads: " + seconds);
  ...