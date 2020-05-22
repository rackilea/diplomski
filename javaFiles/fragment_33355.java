public void calc(List<Pet> pets) {
    // First pass
    Map<String, List<Double>> firstPass = new HashMap<>();
    for (Pet pet : pets) {
        String name = pet.getShop();
        if (firstPass.containsKey(name)) {
            firstPass.get(name).add(pet.getPrice());
        } else {
            List<Double> prices = new ArrayList<>();
            prices.add(pet.getPrice());
            firstPass.put(name, prices);
        }
    }

    // Second pass
    Map<String, Double> results = new HashMap<>();
    for (Map.Entry<String, List<Double>> entry : firstPass.entrySet()) {
        Double average = calcAverage(entry.getValue());
        results.put(entry.getKey(), average);
        // Print results
        System.out.printf("%s: %s%n", entry.getKey(), average);
    }
}

private double calcAverage(List<Double> values) {
    double result = 0;
    for (Double value : values) {
        result += value;
    }
    return result / values.size();
}