@State
public static class S {
    public final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public AtomicReference<Thread> firstThread = new AtomicReference<>();

    public boolean shared() {
        firstThread.compareAndSet(null, Thread.currentThread());
        return lock.readLock().tryLock();
    }

    public boolean exclusive() {
        firstThread.compareAndSet(null, Thread.currentThread());
        return lock.writeLock().tryLock();
    }

    public boolean sameThread() {
        return Thread.currentThread().equals(firstThread.get());
    }

    public boolean locked() {
        return lock.isWriteLockedByCurrentThread();
    }
}

@JCStressTest
@Outcome(id = "false, true, false, false", expect = Expect.ACCEPTABLE, desc = "T1 acquired X, and T2 could not acquire X")
@Outcome(id = "false, false, false, true", expect = Expect.ACCEPTABLE, desc = "T2 acquired X and T1 could not acquire X")
@Outcome(id = "false, true, true, true", expect = Expect.ACCEPTABLE_INTERESTING, desc = "Both actors ran in the same thread!")
@Outcome(id = "true, true, false, true", expect = Expect.ACCEPTABLE_INTERESTING, desc = "Both actors ran in the same thread!")
public static class X_X {
    @Actor
    public void actor1(S s, ZZZZ_Result r) {
        r.r1 = s.sameThread();
        r.r2 = s.exclusive();
    }
    @Actor
    public void actor2(S s, ZZZZ_Result r) {
        r.r3 = s.sameThread();
        r.r4 = s.exclusive();
    }
}