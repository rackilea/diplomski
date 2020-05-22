// Because the code is in a different thread, Thread.sleep(1000) will not pause
    // the current thread and the application will continue as normal
    Thread thread = new Thread(new Runnable() {

        int seconds = 0;

        @Override
        public void run()
        {
            while (true) {

                // wait one second
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                };
                // increment seconds
                seconds++;

                System.out.println(seconds);
            }
        }

    });

    thread.start();