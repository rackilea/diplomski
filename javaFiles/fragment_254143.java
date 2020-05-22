private static final List<CurrencyRange> ranges = Arrays.asList(
        new CurrencyRange(Integer.MIN_VALUE, 0, "some data"),
        new CurrencyRange(1, 115000, "some data"),
        new CurrencyRange(115001, 345000, "some data"),
        new CurrencyRange(345001, 580000, "some data"),
        new CurrencyRange(580001, Integer.MAX_VALUE, "some data")
);

public String determineDataByAmount(int amount) {
    for (CurrencyRange range : ranges) {
        if (range.contains(amount)) {
            return range.getData();
        }
    }
    throw new IllegalStateException(
        "No suitable range found for amount: " + amount);
}

class CurrencyRange {
    private int lowerLimit;
    private int upperLimit;
    private String data;

    public CurrencyRange(int lowerLimit, int upperLimit, String data) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.data = data;
    }

    public boolean contains(int amount) {
        return amount >= lowerLimit && amount <= upperLimit;
    }

    public String getData() {
        return data;
    }
}