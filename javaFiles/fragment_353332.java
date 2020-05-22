public enum Coin {
    Penny       (1),// each coin and it's value
    Nickle      (5),
    Dime        (10),
    Quarter     (25),
    HalfDollar  (50);

    /** The value of the coin in cents. */
    public final int value;

    Coin(int value) {this.value = value;}
}

Map<Coin, Integer> coinCount = new HashMap<>();