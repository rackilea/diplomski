int stateStream(int[] arr) {
    return IntStream.range(0, arr.length - 1)
            .filter(i -> arr[i + 1] - arr[i] > 1) // your condition
            .mapToObj(i -> arr[i])
            .findFirst() // first such occurrence
            .map(i -> i + 1) // to add 1 to the point where the cehck actually failed
            .orElse(0); // some default value
}