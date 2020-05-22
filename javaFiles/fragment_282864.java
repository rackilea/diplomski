class DiscountFactory {
    private static final Map<String, DiscountStrategy> strategies = new HashMap<>();
    private static final DiscountStrategy DEFAULT_STRATEGY = () -> 0;

    static {
        strategies.put("code1", () -> 10);
        strategies.put("code2", () -> 20);
    }

    public DiscountStrategy getDiscountStrategy(String priceCode) {
        if (!strategies.containsKey(priceCode)) {
            return DEFAULT_STRATEGY;
        }
        return strategies.get(priceCode);
    }
}