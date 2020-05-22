public double lastPriceAt(LocalDate date) {
    Map.Entry<LocalDate, Double> price = prices.floorEntry(date);
    while (!retainDates.contains(price.getKey()) {
        price = prices.lowerEntry(price.getKey()); // after some null checks
    }
    return price.getValue(); // after some null checks
}