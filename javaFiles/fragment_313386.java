Map<String, Double> elemWeights = new HashMap<>();

// Associate an element symbol and a weight
// This would be your "double H = 1.008"
elemWeights.put("H", 1.008); 
elemWeights.put("Li", 6.94);
...

public static double multMass(int multiplier, String chem) {
    double weight = elemWeights.get(chem); // And do a lookup
    return weight * multiplier;
}