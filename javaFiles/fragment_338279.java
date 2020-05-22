public static Map<String, HashSet<String>> groupingDishes2(String[][] dishes) {
    return Arrays.stream(dishes)
        .collect(Collectors.toMap(
            arr -> arr[0],
            arr -> Arrays.stream(arr).skip(1).collect(Collectors.toCollection(HashSet::new))));
}