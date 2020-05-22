@SuppressWarnings("unchecked")
static <T> Stream<T> reverse(Stream<T> input) {
    Object[] temp = input.toArray();
    return (Stream<T>) IntStream.range(0, temp.length)
                                .mapToObj(i -> temp[temp.length - i - 1]);
}