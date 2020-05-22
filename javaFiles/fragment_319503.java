public class Prices {
    private volatile Map<String, AtomicInteger> prices = Collections.emptyMap();

    public void putPrice(String ticker, int price) {
        AtomicInteger priceHolder = prices.get(ticker);
        if (priceHolder != null) {
            priceHolder.set(price);
        }
        else {
            HashMap<String, AtomicInteger> newPrices = new HashMap<String, AtomicInteger>(prices);
            newPrices.put(ticker, new AtomicInteger(price));
            prices = newPrices;
        }
    }

    public Integer getPrice(String ticker) {
        AtomicInteger priceHolder = prices.get(ticker);
        if (priceHolder != null) return priceHolder.get();
        else return null;
    }
}