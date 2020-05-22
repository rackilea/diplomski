static void printOwner(ReentrantLock lock) {
    try {
        Field syncField = lock.getClass().getDeclaredField("sync");
        syncField.setAccessible(true);
        Object sync = syncField.get(lock);
        Field exclusiveOwnerThreadField = AbstractOwnableSynchronizer.class.getDeclaredField("exclusiveOwnerThread");
        exclusiveOwnerThreadField.setAccessible(true);
        Thread t = (Thread) exclusiveOwnerThreadField.get(sync);
        if (t == null) {
            System.err.println("No waiter?");
        } else {
            CharSequence sb = Threads.asString(t);
            synchronized (System.out) {
                System.out.println(sb);
            }
        }
    } catch (NoSuchFieldException e) {
        throw new AssertionError(e);
    } catch (IllegalAccessException e) {
        throw new AssertionError(e);
    }
}