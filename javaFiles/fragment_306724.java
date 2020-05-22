public static List<Double> getWeightChanges(ArrayList<Double> weights) {

    List<Double> diffs = new ArrayList<>();
    for (int i = 0; i < weights.size() - 1; i++) {
        diffs.add(weights.get(i + 1) - weights.get(i));
    }

    return diffs;
}