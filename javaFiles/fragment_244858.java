private Map<Integer, String> numbers;
private final Map<Integer, String> initializeNumberMap() {
    numbers = new HashMap<>();
    numbers.put(1, "one");
    ...
    numbers.put(10, "ten");
    return numbers;
}