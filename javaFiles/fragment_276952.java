public class MyThreadLocalData {
    // ...
}

public class TooManyThreadsException
extends RuntimeException {
    // ...
}

public class ThreadManager
{
    private final static int MAX_SIZE = 10;

    private ConcurrentHashMap<Thread,MyThreadLocalData> threadTable = new ConcurrentHashMap<Thread,ThreadManager.MyThreadLocalData>();
    private Object tableLock = new Object();

    public MyThreadLocalData getThreadLocalData() {
        MyThreadLocalData data = threadTable.get(Thread.currentThread());
        if (data != null) return data;

        synchronized (tableLock) {
            if (threadTable.size() >= MAX_SIZE) {
                doCleanup();
            }            

            if (threadTable.size() >= MAX_SIZE) {
                throw new TooManyThreadsException();
            }

            data = createThreadLocalData();
            threadTable.put(Thread.currentThread(), data);
            return data;
        }
    }