private void doCleanup() {
    for (Thread thread : threadTable.keySet()) {
        if (! thread.isAlive()) {
            MyThreadLocalData data = threadTable.remove(thread);
            if (data != null) {
                destroyThreadLocalData(data);
            }
        }
    }