private static int longestSlope(int[][] mat, int num, int i, int j, int depth, int maxDepth ){
    if(canUp(mat, num, i, j) == false && canDown(mat, num, i, j) == false && canRight(mat, num, i, j) == false) && canDown(mat, num, i, j) == false) {
        // this means that you cannot move in any of the 4 directions: the base case
        return maxDepth;
    }
    if (canUp(mat, num, i, j)) {
        maxDepth = longestSlope(mat, num, i - 1, j, depth, maxDepth + 1);
        if (depth < maxDepth) {
            depth = maxDepth;
        }
        maxDepth = 0;
    }
    if (canDown(mat, num, i, j)) {
        maxDepth = longestSlope(mat, num, i + 1, j, depth, maxDepth + 1);
        if (depth < maxDepth) depth = maxDepth;
        maxDepth = 0;
    }
    if (canRight(mat, num, i, j)) {
        maxDepth = longestSlope(mat, num, i, j + 1, depth, maxDepth + 1);
        if (depth < maxDepth) depth = maxDepth;
        maxDepth = 0;
    }
    if (canLeft(mat, num, i, j)) {
        maxDepth = longestSlope(mat, num, i, j - 1, depth, maxDepth + 1);
        if (depth < maxDepth) depth = maxDepth;
    } 
    return depth;
}