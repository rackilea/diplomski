static final Comparator<CustomObject> COMPARATOR = (o1, o2) -> {
    int[] arr1 = o1.getArray();
    int[] arr2 = o2.getArray();
    return IntStream.range(0, arr1.length)
                    .map(i -> Integer.compare(arr1[i], arr2[i]))
                    .filter(i -> i != 0)
                    .findFirst()
                    .orElse(0);
};