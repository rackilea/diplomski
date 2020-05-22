private static final int[][][] TOUR = new int[][][]{
    {{0, 0}, {4, 0}, {4, 3}, {0, 3}}, 
    {{0, 0}, {3, 0}, {3, 4}, {0, 0}}, 
    {{1, 3}, {3, 2}, {0, 4}, {2, 2}, {3, 1}, {1, 4}, {2, 3}}, 
    {{-2, -1}, {-2, +3}, {4, 3}, {0, 0}} 
};


public static int[][] createDeepCopyOfTour(int idx) {
    return TOUR[idx];
}