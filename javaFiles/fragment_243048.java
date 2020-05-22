@State
public static class S {
    public final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public boolean shared() {
        return lock.readLock().tryLock();
    }

    public boolean exclusive() {
        return lock.writeLock().tryLock();
    }

    public boolean locked() {
        return lock.isWriteLockedByCurrentThread();
    }
}

@JCStressTest
@Outcome(id = "true, false, false", expect = Expect.ACCEPTABLE, desc = "T1 acquired X, and T2 could not acquire S")
@Outcome(id = "false, false, true", expect = Expect.ACCEPTABLE, desc = "T2 acquired S and T1 could not acquire X")
@Outcome(id = "true, true, true", expect = Expect.ACCEPTABLE, desc = "T1 acquired X and then acquired S")
public static class X_S {
    @Actor
    public void actor1(S s, ZZZ_Result r) {
        r.r1 = s.exclusive();
    }
    @Actor
    public void actor2(S s, ZZZ_Result r) {
        r.r2 = s.locked();
        r.r3 = s.shared();
    }
}