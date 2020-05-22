private static List<Integer> change(int remaining, List<Integer> coins, int pos) { // Updated method return type;

    if (pos < 0 || pos >= DENOMINATIONS.length) { // check if position is invalid
        return new ArrayList<>(); // return an empty list
    }

    if (remaining == DENOMINATIONS[pos]) { // check if remaining is equal to denominations[pos]
        coins.add(DENOMINATIONS[pos]); // add the denominations to the coins result
        return coins; // return the result
    } else if (remaining > DENOMINATIONS[pos]) { // check if remaining is greater than denominations[pos]
        coins.add(DENOMINATIONS[pos]);// add the possible denominations to the coins result
        remaining = remaining - DENOMINATIONS[pos]; // calculate the new remaining
        if (remaining >= DENOMINATIONS[pos]) { // check if remaining is greater than or equal to denominations[pos]
            return change(remaining, coins, pos); // stick to this position
        } else {
            return change(remaining, coins, pos + 1); // increment pos to go to the lower denominations
        }
    } else if (remaining < DENOMINATIONS[pos]) { // check if remaining is lesser than denominations[pos]
        if (coins.isEmpty()) { // if coins is empty then go to the next denomination
            return change(remaining, coins, pos + 1);
        } else {
            coins.remove(coins.size() - 1); // remove the previous denomination
            return change(remaining + DENOMINATIONS[pos - 1], coins, pos); // go back to the previous remaining and // try this DENOMINATIONS[pos]
        }
    }
    return coins;
}