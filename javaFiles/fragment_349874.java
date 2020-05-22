ExecutorService ex = Executors.newFixedThreadPool(10);
    for (;;) {
        List<Future<?>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<?> f = ex.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("running poller " + new Date());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("5000 passed");
                }
            });
            list.add(f);
        }
        for (Future<?> f : list) {
            f.get();
        }
    }