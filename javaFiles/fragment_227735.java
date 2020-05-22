private static List<Pricing> getAllPricings() {
    List<Pricing> pricings = new ArrayList<>();
    pricings.add(new Pricing(1, 10.5, "AAA"));
    pricings.add(new Pricing(2, 9.5, "AAA"));
    pricings.add(new Pricing(3, 10.0, "AAA"));
    pricings.add(new Pricing(4, 10.0, "BBB"));
    pricings.add(new Pricing(5, 10.0, "BBB"));
    return pricings;
}