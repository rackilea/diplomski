public static double getUnique2(double arr[]) {
    return  Arrays.stream(arr).boxed()
            .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
            .entrySet().stream().filter(e->e.getValue() == 1)
            .map(Map.Entry::getKey).findFirst().orElse(-1.);
}