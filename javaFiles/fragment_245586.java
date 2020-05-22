public enum Currency {PENNY, NICKLE, DIME, QUARTER};

Currency coin = Currency.PENNY;
Currency noCoin = null
Currency pennyCoin = Currency.PENNY;
Currency otherCoin = Currency.NICKLE;

if (coin != null) {
    System.out.println("The coin is not null");
}

if (noCoin == null) {
    System.out.println("noCoin is null");
}

if (coin.equals(pennyCoin)) {
    System.out.println("The coin is a penny, because its equals pennyCoin");
}

if (coin.equals(Currency.PENNY)) {
    System.out.println("The coin is a penny, because its equals Currency.PENNY");
}

if (!coin.equals(otherCoin)) {
    System.out.println("The coin is not an otherCoin");
}

switch (coin) {
    case PENNY:
        System.out.println("It's a penny");
        break;
    case NICKLE:
        System.out.println("It's a nickle");
        break;
    case DIME:
        System.out.println("It's a dime");
        break;
    case QUARTER:
        System.out.println("It's a quarter");
        break;
}

Output: "It's a penny"