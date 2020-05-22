public <T, R> R executeWithLock(String lockName, T input, Function<T, R> func) throws LockUnavailableException {
    LockItem lockItem = acquireLock(lockName);
    try  {
        R output = func.apply(input);
        return output;
    } finally {
        releaseLock(lockItem);
    }
}