public double distance(List<Double> instance1, List<Double> instance2) {
    double dist = 0.0;

    for (int i = 0; i < instance1.size(); i++) {
        double x = instance1.get(i);
        double y = instance2.get(i);

        if (Double.isNaN(x) || Double.isNaN(y)) {
            continue; // Mark missing attributes ('?') as NaN.
        }

        dist += (x-y)*(x-y);
    }

    return Math.sqrt(dist);
}