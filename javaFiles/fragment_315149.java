public static List<String> f(int n, List<String> input) {
    int fence = IntStream.range(0, input.size())
                         .filter(idx -> input.get(idx).equals("B")) // leave only B's
                         .skip(n-1)
                         .findFirst() // an index of n-th B
                         .getAsInt(); // with throw NoSuchElementException if not enough B's
    return input.subList(0, fence+1);
}