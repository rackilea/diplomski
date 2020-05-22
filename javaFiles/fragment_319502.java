public class Prices {
    private volatile Map<String, Integer> prices = Collections.emptyMap();

    public void putPrice(String ticker, int price) {
        HashMap<String, Integer> newPrices = new HashMap<String, Integer>(prices);
        newPrices.put(ticker, price);
        prices = newPrices;
    }

    public Integer getPrice(String ticker) {
        return prices.get(ticker);
    }
}