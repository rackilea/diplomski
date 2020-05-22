public final class RxThreadFactory extends AtomicLong implements ThreadFactory {

    ...

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, prefix + incrementAndGet());
        t.setDaemon(true);
        return t;
    }
}