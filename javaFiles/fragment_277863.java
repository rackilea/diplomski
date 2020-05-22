final Lock lock = new Lock();
lock.lock();
expectLastCall().andAnswer(new IAnswer<Void>() {
    @Override public Void answer() throws Throwable {
        lock.unlock();
        throw new RuntimeException("TEST EXCEPTION");
    }
});     
doStuff();
lock.lock();
verify(mock);