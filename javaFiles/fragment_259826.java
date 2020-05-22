public List<Integer> sublistSums(List<Integer> numbers) {
    if (numbers.isEmpty()) {
        return Collections.emptyList();
    }

    List<Integer> results = new ArrayList<>();

    List<Integer> sumsOfTail = sublistSums(numbers.subList(1, numbers.size()));
    results.addAll(sumsOfTail);
    results.addAll(addToAll(numbers.get(0), sumsOfTail));

    return Collections.unmodifiableList(results);
}