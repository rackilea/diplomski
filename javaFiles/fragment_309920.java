public static void main(String[] args) throws Exception {
    System.out.println(System.getProperty("java.runtime.version"));
    ReferenceQueue<FileHandler> q = new ReferenceQueue<>();
    for (int i=0; i<100; i++) {
        WeakReference<FileHandler> h = new WeakReference<>(
                new FileHandler("./test_%u.log", 10000, 2, true), q);
        while (q.poll() != h) {
            System.runFinalization();
            System.gc();
            System.runFinalization();
            Thread.yield();
        }
    }
}