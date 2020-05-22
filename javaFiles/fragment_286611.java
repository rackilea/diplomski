public class Counter {
    private BigDecimal total = new BigDecimal("0.00");
    private final Product p;

    public Counter(Product p) {
        this.p = p;
    }

    public void add(String product) {
        TreeMap<String, BigDecimal> pMap = p.getProductMap();
        if (pMap.containsKey(product)) {
            BigDecimal price = pMap.get(product);
            total = total.add(price);
        } else {
            System.out.printf("%s does not exist. Please try again.%n", product);
        }
        System.out.printf("Adding %s. Total is %s%n", product, total);
    }
}