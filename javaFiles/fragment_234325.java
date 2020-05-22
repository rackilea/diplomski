public static LabColor findNearest(LabColor sample, LabColor[] chart) {
    LabColor nearest = null;
    float minDistanceSquared = Float.POSITIVE_INFINITY;
    for (int i = 0; i < chart.length; i++) {
        float dL = sample.L - chart[i].L;
        float da = sample.a - chart[i].a;
        float db = sample.b - chart[i].b;
        float distanceSquared = dL*dL + da*da + db*db;
        if (distanceSquared < minDistanceSquared) {
            nearest = chart[i];
            minDistanceSquared = distanceSquared;
        }
    }
    return nearest;
}