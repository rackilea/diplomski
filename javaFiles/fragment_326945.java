class MyClass {

    private boolean myAttribute = false;

    private Set<String> threads = new HashSet<>();
    public Set<String> getThreadsSet() {
        return threads;
    }

    public boolean isMyAttribute() {
        synchronized (threads) {
            threads.add(Thread.currentThread().getName());
        }
        return myAttribute;
    }

}