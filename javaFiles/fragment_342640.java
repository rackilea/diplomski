private static final int[][][] TOUR = new int[][][]{
    {{0, 0}, {4, 0}, {4, 3}, {0, 3}}, 
    {{0, 0}, {3, 0}, {3, 4}, {0, 0}}, 
    {{1, 3}, {3, 2}, {0, 4}, {2, 2}, {3, 1}, {1, 4}, {2, 3}}, 
    {{-2, -1}, {-2, +3}, {4, 3}, {0, 0}} 
};


public static int[][] createDeepCopyOfTour(int idx) {
    int tour[][] = new int[TOUR[idx].length][2];
    for (int i = 0; i < TOUR[idx].length; i++)
    {
        tour[i][0] = TOUR[idx][i][0];
        tour[i][1] = TOUR[idx][i][1];
    }

    return tour;
}