public static void main(String[] args) {
    HashMap<String, BigDecimal> bd_map = new HashMap<>();

    bd_map.merge("Shirts", new BigDecimal("5.99"), BigDecimal::add);
    bd_map.merge("Shirts", new BigDecimal("4.50"), BigDecimal::add);
    bd_map.merge("Shoes", new BigDecimal("15.99"), BigDecimal::add);
    bd_map.merge("Hats", new BigDecimal("8.00"), BigDecimal::add);
    bd_map.merge("Shirts", new BigDecimal("8.99"), BigDecimal::add);
    bd_map.merge("Shoes", new BigDecimal("22.00"), BigDecimal::add);
    bd_map.merge("Hats", new BigDecimal("7.00"), BigDecimal::add);

    System.out.println("Shirts: " + bd_map.get("Shirts"));
    System.out.println("Hats: " + bd_map.get("Hats"));
    System.out.println("Shoes: " + bd_map.get("Shoes"));
}