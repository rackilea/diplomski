int size = list.size();

List<Integer> result = list.stream()
    .limit(size - 1)
    .map(i -> i - 2)
    .collect(Collectors.toCollection(() -> new ArrayList(size)));

result.add(list.get(size - 1));