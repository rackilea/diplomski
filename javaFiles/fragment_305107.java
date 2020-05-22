class LockHolder { // Package private class
    public static Object LOCK = new Object();
}

public interface ColumnCollection {
    default void addUniqueColumns(List<String> names) {
        synchronized (LockHolder.LOCK) {
            ... do something
        }
    }
}