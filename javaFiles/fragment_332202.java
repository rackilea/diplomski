public class LongestIncreasingPath {

    private static final int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    private int rows, cols;
    //avoid non-volatile class variable that may be updated by more than one thread
    //use local variables instead
    //private int maxDist;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        rows = matrix.length;
        cols = matrix[0].length;

        int maxDist = 0; //retain max found
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                //bug fix: use distance (matrix[row][col]) instead of 1
                int  distance = dfs(matrix, row, col, matrix[row][col]);
                maxDist = Math.max(distance, maxDist);
            }
        }
        return maxDist;
    }

    private int dfs(int[][] matrix, int row, int newCol, int dist) {

        int maxDist = dist; 
        for (int[]dir : dirs) {
            int newRow = row + dir[0], y = newCol + dir[1];
            if (0 <= newRow && newRow < rows && 0 <= y && y < cols &&
                                        matrix[newRow][y] > matrix[row][newCol]) {
                //bug fix: //add new distance matrix[x][y] instead of 1
                maxDist = Math.max(maxDist, dfs(matrix, newRow, y, dist + matrix[newRow][y]));
            }
        }
        return maxDist;
    }

    public static void main(String[] args) {

        LongestIncreasingPath lIP = new LongestIncreasingPath();
        int[][] nums = { { 9, 9, 4 },
                         { 6, 6, 8 },
                         { 2, 2, 1 }
                        };
        //printout test case 1
        System.out.println(lIP.longestIncreasingPath(nums));
        nums = new int[][]{ { 5, 6, 7 },
                            { 4, 9, 8 },
                            { 3, 2, 1 }
                        };
        //printout test case 2
        System.out.println(lIP.longestIncreasingPath(nums));
    }
}