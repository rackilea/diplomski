public static void main(String... args) throws InterruptedException {
    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Final stats");
        }
    }));
    System.out.println("PID " + ManagementFactory.getRuntimeMXBean().getName());
    while (true) {
        System.out.println("stats");
        Thread.sleep(2000);
    }
}