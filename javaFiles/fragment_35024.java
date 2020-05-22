private final ConcurrentHashMap<String, AtomicInteger> results = new ConcurrentHashMap<>();

public void acceptVote(int index) {
    AtomicInteger currentResult = results.get(candidates.get(index));
    if (currentResult == null) {
        currentResult = results.putIfAbsent(candidates.get(index), new AtomicInteger(1));
        if (currentResult != null) {
            currentResult.getAndIncrement();
        }
    } else {
        currentResult.getAndIncrement();
    }
}