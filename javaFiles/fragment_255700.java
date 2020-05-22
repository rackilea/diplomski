new Thread(new Runnable() {
        @Override
        public void run() {
            while (!Thread.interrupted()) {
                System.out.println("Hello");
            }
        }
    }).start();