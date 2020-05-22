public static void main(String[] args) throws InterruptedException {
    final long WORKING_TIME = 10 * 60 * 1000;
    final long SLEEPING_TIME = 5 * 60 * 1000;

    long startTime;
    while (true) {
        startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() < startTime + WORKING_TIME) {
            System.out.println("working..."); // implement your logic here
        }
        Thread.sleep(SLEEPING_TIME); // sleeping for SLEEPING_TIME
    }
}