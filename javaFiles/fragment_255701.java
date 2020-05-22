final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    Runnable codeToRunInThisThread = queue.take();
                    codeToRunInThisThread.run();
                }
            } catch (InterruptedException ignored) {}
        }
    }).start();