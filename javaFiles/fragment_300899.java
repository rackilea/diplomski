ConcurrentHashMap<String, Integer> keyMap = new ConcurrentHashMap<>();
AtomicInteger sequence = new AtomicInteger();

public void update(String key1, String key2) {
    Integer id1 = keyMap.computeIfAbsent(key1, s -> sequence.getAndIncrement());
    Integer id2 = keyMap.computeIfAbsent(key2, s -> sequence.getAndIncrement());

    Bar bar = new Bar(id1, id2);
    // ... do something with bar
}