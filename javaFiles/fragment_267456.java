List<String> bestFundraisers(String[] names, double[] totals) {
    final List<String> winners = new ArrayList<>();
    final int n = names.length;
    // optional: throw an exception if totals.length != n
    double max = Double.NEGATIVE_INFINITY;
    for (int i = 0; i < n; ++i) {
        double raised = totals[i];
        if (raised >= max) [
            if (raised > max) {
                winners.clear();
                max = raised;
            }
            winners.add(names[i]);
        }
    }
    return winners;
}