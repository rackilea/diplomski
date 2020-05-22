CountDownLatch cdl = new CountDownLatch(nOP);
    Thread[] threads = new Thread[nOP];
    for (int i = 0; i<threads.length; i++) {
        threads[i] = new Thread(new Runnable() {
            public void run() {
                values.add(sum(tab));
                cdl.countDown();
            }
        });
        threads[i].start();
    }
    cdl.await();