ExecutorService executorService = Executors.newSingleThreadExecutor();
    Data data = new Data();
    SynchronousQueue queue = new SynchronousQueue();

    while (true) {
        doStuff();
        doStuff();

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 256; i++) {
                    System.out.println("Data " + i + ": " + data.get(i));
                }
                queue.put(data);
            }
        });

        doStuff();
        doStuff();

        data = queue.take();
        for (int i = 0; i < 256; i++) {
            data.set(i, (byte) (data.get(i) + 1));
        }

        doStuff();
        doStuff();
    }