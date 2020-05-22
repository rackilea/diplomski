public static class a {

    static boolean finish = false;

    public static void main(String[] args) throws InterruptedException {

        finish = false;

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Referee());
        executorService.execute(new Player(1));
        executorService.execute(new Player(2));

        // wait for user to press enter, just for testing
        new Scanner(System.in).nextLine();
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}