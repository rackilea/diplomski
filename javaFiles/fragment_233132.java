public static List<Stocks> matching(Stocks[] one, Stocks[] two) {
    Set<Integer> stockPrices = Arrays.stream(one)
                                     .map(stock -> stock.stockPrice)
                                     .collect(Collectors.toSet());
    return Arrays.stream(two)
                 .filter(stock -> stockPrices.contains(stock.stockPrice))
                 .collect(Collectors.toList());
}