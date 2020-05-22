public void calc(List<Pet> pets) {
    Map<String, Double> hm = new HashMap<>();
    for (Pet i : pets) {
        String name = i.getShop();
        // If the map already has the pet use the current value, otherwise 0.
        double price = hm.containsKey(name) ? hm.get(name) : 0;
        price += i.getPrice();
        hm.put(name, price);
    }
    System.out.println("");
    for (String key : hm.keySet()) {
        System.out.printf("%s: %.2f%n", key, hm.get(key));
    }
}