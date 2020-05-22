final BlockingQueue<Runnable> codeQueue = new LinkedBlockingQueue<>();
    Thread serverThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    Runnable code = codeQueue.take();
                    // call code in my context.
                    code.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    });
    Thread clientThread = new Thread(new Runnable() {
        @Override
        public void run() {
            codeQueue.add(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Hello from Server Thread.");
                }
            });
        }
    });