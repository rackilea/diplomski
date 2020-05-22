public static void main(String[] args) throws InterruptedException {
    ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
    ExecutorService pool = Executors.newFixedThreadPool(4);
    Iterator<Integer> it = getIt();
    Task t = new Task(map);
    while (it.hasNext()) {
        t.add(it.next());
        if (t.size()>=1000 || !it.hasNext()) {
            pool.submit(t);
            t = new Task(map);
        }
    }
    pool.shutdown();
    pool.awaitTermination(1, TimeUnit.DAYS);

    // Breakpoint here to inspect map
    System.out.println("Done!");
}