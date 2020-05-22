class FrequencyCounter {
    private final int[] counts;
    private final Object[] locks;

    FrequencyCounter(int max) {
        counts = new int[max];
        locks = new Object[max];
        IntStream.range(0, max).forEach(i -> locks[i] = new Object());
    }

    void count(int event) {
        synchronized (locks[event]) {
            counts[event]++;
        }
    }

    int frequency(int event) {
        synchronized (locks[event]) {
            return counts[event];
        }
    }
}