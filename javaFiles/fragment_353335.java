public Map<Coin, Integer> getChange(int amount) {
    Map<Coin, Integer> ret = getDefaultMap();
    if (getChangeImpl(amount, false, getDefaultMap())) {// if we have the right coins...
        getChangeImpl(amount, true, ret);// Do the real thing
        return ret;
    }

    throw new IllegalArgumentException("Insufficient coins!!");// fall through case
} 

private boolean getChangeImpl(int amount, boolean isMock, Map<Coin, Integer> out) {    
    ...
    for (Coin c: types)
        while (amountLeft >= c.value && getCoinCount(c) > 0) {
            ...
            if (isMock == false)// if this is the real thing
                addCoins(c, -1);// remove one coin from inventory
        }
    return amountLeft == 0;// if we have the correct coins, this will be zero
}