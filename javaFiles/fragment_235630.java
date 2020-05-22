public static void main(String[] args) {
    HashMap<String, BigDecimal> bd_map = new HashMap<>();
    bd_map.put("Shirts", BigDecimal.ZERO);
    bd_map.put("Hats", BigDecimal.ZERO);
    bd_map.put("Shoes", BigDecimal.ZERO);

    bd_map.put("Shirts", bd_map.get("Shirts").add(new BigDecimal("5.99")));
    bd_map.put("Shirts", bd_map.get("Shirts").add(new BigDecimal("4.50")));
    bd_map.put("Shoes", bd_map.get("Shoes").add(new BigDecimal("15.99")));
    bd_map.put("Hats", bd_map.get("Hats").add(new BigDecimal("8.00")));
    bd_map.put("Shirts", bd_map.get("Shirts").add(new BigDecimal("8.99")));
    bd_map.put("Shoes", bd_map.get("Shoes").add(new BigDecimal("22.00")));
    bd_map.put("Hats", bd_map.get("Hats").add(new BigDecimal("7.00")));

    System.out.println("Shirts: " + bd_map.get("Shirts"));
    System.out.println("Hats: " + bd_map.get("Hats"));
    System.out.println("Shoes: " + bd_map.get("Shoes"));
}