public class CoinDispenser {
    private final Map<Coin, Integer> coinCount = getDefaultMap();

    public void addCoins(Coin type, int amount) {
        coinCount.put(type, amount + getCoinCount(type));
    }

    public int getCoinCount(Coin type) {
        return coinCount.get(type);
    }

    // Why not use an empty map you ask? Map.get will return null
    // if the key does not exist. So for the default map we get all
    // the possible coins and add them to the map with the default
    // count of zero
    private static Map<Coin, Integer> getDefaultMap() {
        Map<Coin, Integer> ret = new HashMap<>();
        for (Coin c: Coin.values())
            ret.put(c, 0);
        return ret;
    }

    /**
     * Get the change in the available coins. Please note that
     * this removes the coins from the vending machine.
     */
    public Map<Coin, Integer> getChange(int amount) {
        Map<Coin, Integer> ret = getDefaultMap();

        if (getChangeImpl(amount, true, getDefaultMap())) {// if we have the right coins...
            getChangeImpl(amount, false, ret);// do the real thing
            return ret;
        }

        throw new IllegalArgumentException("Insufficient coins!!");// fall through case
    }

    /** The private version of get change...
     *
     * @param amount The amount of change needed
     * @param isMock If true, this will not remove coins from the dispenser
     * @param out The output map
     * @return True, if we have the proper coins
     */
    private boolean getChangeImpl(int amount, boolean isMock, Map<Coin, Integer> out) {
        List<Coin> types = Arrays.asList(Coin.values());// get the coin types, in least to greatest order...
        Collections.reverse(types);// flip the array because we need the big coins to go first
        int amountLeft = amount;// how much change do we still need to make up?

        for (Coin c: types)
            while (amountLeft >= c.value && getCoinCount(c) > 0) {// while the coin is the right
                                                                    // value and we still have it
                amountLeft -= c.value;// de-inc amountLeft by the coins value
                out.put(c, out.get(c) + 1);// add the coin to the out
                if (isMock == false)// if this is the real thing
                    addCoins(c, -1);// remove one coin from inventory
            }


        return amountLeft == 0;// if we don't have the correct coins, this won't be zero
    }

    // This belongs in it's own file
    public enum Coin {
        Penny       (1),// each coin and it's value
        Nickle      (5),
        Dime        (10),
        Quarter     (25),
        HalfDollar  (50);

        /**
         * The value of the coin in cents.
         */
        public final int value;

        Coin(int value) {this.value = value;}
    }

    public static void main(String[] args) {
        CoinDispenser vm = new CoinDispenser();
        vm.addCoins(Coin.Penny, 45);
        vm.addCoins(Coin.Dime, 3);
        vm.addCoins(Coin.Quarter, 1);

        System.out.println(vm.getChange(36));// 1 quarter, 1 dime, 1 penny
        System.out.println(vm.getChange(36));// 2 dimes, 6 pennies
        System.out.println(vm.getChange(36));// 36 pennies
        System.out.println(vm.getChange(36));// IllegalArgumentException: Not enough coins!!
    }
}