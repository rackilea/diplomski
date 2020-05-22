class MyLockedList {
    private final Object lock = new Object();
    private final List<Integer> theList = new ArrayList<>();

    void add(int i) {
        synchronized(lock) {
            theList.add(i);
        }
    }

    void printAll() {
        synchronized(lock) {
            for (Integer i : theList) {
                System.out.println(... i ...);
            }
        }
    }

    ...
}