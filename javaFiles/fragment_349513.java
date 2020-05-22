List<Event> remove(List<Event> input, BiPredicate<Event,Event> matcher) {
    int n = input.size();
    boolean[] flags = new boolean[n];
    ArraySetRange(flags, 1, n, i -> matcher.test(input.get(i-1), input.get(i)));
    ArraySetRange(flags, 0, n-1, i -> flags[i] || flags[i+1]);
    return IntStream.range(0, n)
        .filter(i -> ! flags[i])
        .mapToObj(input::get)
        .collect(toList());
}