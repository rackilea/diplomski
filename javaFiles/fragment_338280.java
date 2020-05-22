public static Map<String, Set<String>> groupingDishes(String[][] dishes) {
    return Arrays.stream(dishes)
        .collect(Collectors.toMap(
            arr -> arr[0],
            arr -> Arrays.stream(arr).skip(1).collect(Collectors.toSet())));
}