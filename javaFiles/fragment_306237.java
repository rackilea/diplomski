public void start() throws IOException {
..............
    try {
        Thread.sleep(1L * 60L * 1000L);
    } catch (InterruptedException e) {
        System.out.println(e);
    }
...............
}