public static void main(String[] args) throws InterruptedException {
    final int nthreads = Integer.parseInt(args[0]);
    final Thread[] workers = new Thread[nthreads];
    for (int i = 0; i < nthreads; ++i) {
        workers[i] = new Thread(new PrintingTask(System.out, i + 1, 100, nthreads));
    }
    for (final Thread t : workers) {
        t.start();
    }
    for (final Thread t : workers) {
        t.join();
    }
}