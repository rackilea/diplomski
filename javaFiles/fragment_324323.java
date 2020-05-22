ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future<?> future = null;
    try {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    // it the timeout happens, the thread should be interrupted. Check it to let the thread terminates.
                    if (Thread.currentThread().isInterrupted()) {
                        return;
                    }
                    exampleMethod();
                }

            }
        };

        future = executorService.submit(r);
        future.get(10, TimeUnit.SECONDS);
    }

    // time is passed
    catch (final TimeoutException e) {
        System.out.println("I was to slow");
        // you cancel the future
        future.cancel(true);
    }
    // other exceptions
    catch (Exception e) {
        e.printStackTrace();
    } finally {
        executorService.shutdown();
    }
}