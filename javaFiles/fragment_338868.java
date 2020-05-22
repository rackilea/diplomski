public static int[][] getClosestWaypoints(int[][] tour) {
    double minDist = Integer.MAX_VALUE;
    int[] pt1 = null;
    int[] pt2 = null;
    for (int i = 0; i < tour.length-1; ++i) {
        for (int j = i+1; j < tour.length; ++j) {
            double dist = calcDistanceBetweenWaypoints(tour[i], tour[j]);
            if (dist < minDist) {
                minDist = dist;
                pt1 = tour[i];
                pt2 = tour[j];
            }
        }
    }
    return new int[][] {pt1, pt2};
}