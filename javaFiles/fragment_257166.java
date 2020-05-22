int size = list.size();

List<Integer> result = list.stream()
    .map(i -> i - 2)
    .collect(Collectors.toCollection(() -> new ArrayList(size)));

result.set(size - 1, list.get(size - 1));