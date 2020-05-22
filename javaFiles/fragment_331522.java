public static void main(String[] args) {
    ExampleBean e = new ExampleBean();

    System.out.println("Setting rate to 50%");
    e.discountRateProperty().set(new BigDecimal(50.0));
    System.out.println("-> value=" + e.getDiscountvalue());

    System.out.println("Setting value to 25");
    e.discountValueProperty().set(new BigDecimal(25.0));
    System.out.println("-> rate=" + e.getDiscountRate() + "%");
}