public Iterator<Integer> iterator() {
    return Arrays.stream(array)
            .map(Arrays::stream)
            .flatMap(IntStream::boxed)
            .iterator();
}