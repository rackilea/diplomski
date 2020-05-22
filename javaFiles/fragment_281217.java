public enum AccountRange {

    RANGE1(100, 200), RANGE2(201, 300), RANGE3(301, 900);

    private final int min;
    private final int max;

    private AccountRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public String getRangeAccount() {
        return String.format("%d,%d", min, max);
    }

    public static AccountRange get(int val) {
        return Arrays.stream(values())
                     .filter(r -> val >= r.min && val <= r.max)
                     .findFirst()
                     .orElse(null);
    }
}