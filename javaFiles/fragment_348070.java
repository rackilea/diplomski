time(new Runnable() {
    public void run() {
        System.out.println("statements");
    }
});

static void time(Runnable r) {
    long startTime = System.nanoTime();
    r.run();
    System.out.println("Runtime: " + (System.nanoTime() - startTime));
}