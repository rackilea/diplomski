final CountDownLatch latch = new CountDownLatch(1);

        view.post(new Runnable() {
            public void run() {
                try {
                    // Do stuff on the UI thread
                } finally {
                    latch.countDown();
                }
            }
        });

        try {
            if (!latch.await(CAPTURE_TIMEOUT, TimeUnit.MILLISECONDS)) {
                return;
            }
        } catch (InterruptedException e) {
            // Handle exception
        }