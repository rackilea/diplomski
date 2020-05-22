public void printOutliers() {
    for (int i : n) {
        if (isOutlier(i, avg, stdev)) {
            ...
        }
    }
}