public class Cost {
    private int amount;
    private Currency currency;

    public Cost(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }
    public enum Currency {
        GOLD { public String toString() { return "gold"; } },
        SILVER { public String toString() { return "silver"; } },
        COPPER { public String toString() { return "copper"; } },
        STONE { public String toString() { return "stone"; } },
        RARE_METAL { public String toString() { return "rare"; } }
    }

    public String getImageName() {
        return new String(currency.toString()+".png");
    }

    public int getAmount() {
    return amount;
    }

    public String getCurrency() {
        return currency.toString();
    }
}