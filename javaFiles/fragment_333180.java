private void StepA() {
        Log.d("RT", "StepA initiated");
        final CountDownLatch latchA = new CountDownLatch(1);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("RT", "Thread t Begins");
                ThreadA threadA = new ThreadA();
                try {
                    JSONObject jsonObject = threadA.execute().get(10, TimeUnit.SECONDS);
                    parseA(jsonObject);
                    latchA.countDown();
                    Log.d("RT", "Thread t Ends");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        try {
            latchA.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d("RT", "StepA END");
    }