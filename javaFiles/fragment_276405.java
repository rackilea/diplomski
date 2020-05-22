List<int[]> collect = Arrays.stream(arr)
    .collect(Collectors.groupingBy(ints -> ints[0]))
    .entrySet().stream()
    .map(entry -> new int[]{
        entry.getKey(),   // [0]
        entry.getValue().stream().mapToInt(value -> value[1]).sum(), // [1]
        entry.getValue().stream().mapToInt(value -> value[2]).sum()  // [2]
    })
    .collect(Collectors.toList());