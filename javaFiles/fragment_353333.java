public class CoinDispenser {
    private final Map<Coin, Integer> coinCount = getDefaultMap();

    public void addCoins(Coin type, int amount) {
        coinCount.put(type, amount + getCoinCount(type));
    }

    public int getCoinCount(Coin type) {
        return coinCount.get(type);
    }

    // We can't start with an empty map
    private static Map<Coin, Integer> getDefaultMap() {
        Map<Coin, Integer> ret = new HashMap<>();
        for (Coin c: Coin.values())
            ret.put(c, 0);
        return ret;
    }

    public enum Coin {...}
}