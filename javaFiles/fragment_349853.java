public static Map<Integer, Double> derivativePoly2(Map<Integer, Double> degreeAndCoeff) {
    Map<Integer, Double> result = new HashMap<Integer, Double>();

    for (Map.Entry<Integer, Double> term : degreeAndCoeff.entrySet() {
        int exponent = term.getKey();
        double coefficient = term.getValue();

        // ... result.put(something, somethingElse);
    }

    return result;
}