private Executor executor = Executors.newFixedThreadPool(1);

public void method1() {
    System.out.println("Method 1 called");
}

public void method2() {
    System.out.println("Method 2 called");
}

public void method3() {
    System.out.print("Method 3 called");
}

public void start() {
    executor.execute(new Runnable() {
        private final long WAIT_TIME = 3000; // ms

        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            method1();
            sleep(startTime);

            startTime = System.currentTimeMillis();
            method2();
            sleep(startTime);

            startTime = System.currentTimeMillis();
            method3();
            sleep(startTime);
        }

        private void sleep(long startTime) {
            long timeTaken = System.currentTimeMillis() - startTime;
            long timeLeft = WAIT_TIME - timeTaken;
            if(timeLeft < 0) return;

            try {
                Thread.sleep(timeLeft);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    });
}