public static Map<String, Set<String>> groupingDishes(String[][] dishes) {
    return Arrays.stream(dishes)
        .collect(Collectors.toMap(
            arr -> arr[0],
            arr -> new HashSet<>(Arrays.asList(arr).subList(1, arr.length))));
}