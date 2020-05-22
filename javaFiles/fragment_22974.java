ExecutorService checkTasksExecutorService = new ThreadPoolExecutor(1, 10,
                100000, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>());

        for (int i = 0; i < 10; i++) {
            checkTasksExecutorService.execute(new Runnable() {

                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "   running!");
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
        }

        //Thread.sleep(1000000); //instead this use following

//stop accepting new tasks
        checkTasksExecutorService.shutdown();

while (!checkTasksExecutorService.isTerminated()) {
            Thread.sleep(100);
        }