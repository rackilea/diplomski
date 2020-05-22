public Map<Coin, Integer> getChange(int amount) {
    List<Coin> types = Arrays.asList(Coin.values());
    Collections.reverse(types);

    Map<Coin, Integer> ret = new HashMap<>();
    fillWithDefault(ret);
    int amountLeft = amount;

    for (Coin c: types) {
        while (amountLeft >= c.value && getCoinCount(c) > 0) {
            amountLeft -= c.value;
            ret.put(c, ret.get(c) + 1);
            addCoins(c, -1);
        }
    }

    return ret;
}