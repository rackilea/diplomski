public class Main {

    static int totalRows = 4;
    static int totalCols = 6;
    static int[] rowNbr = {1, -1, 0, 0};
    static int[] colNbr = {0, 0, 1, -1};
    //static int count = 0; //count is no longer needed
    static boolean[][] visited = new boolean[4][6];

    public static void main(String[] args) {
        int mat[][] = {{1, 0, 0, 0, 0, 0}, //
                {1, 1, 1, 1, 1, 0}, //
                {1, 0, 0, 0, 0, 0}, //
                {1, 0, 0, 0, 0, 0}};

        int maxDepth = dfs(mat, 0, 0, 1);
        System.out.println(maxDepth);

        //test second row {1, 1, 0, 0, 0, 0} like Damien mentioned
        mat = new int[][] {{1, 0, 0, 0, 0, 0}, //
                {1, 1, 0, 0, 0, 0}, //
                {1, 0, 0, 0, 0, 0}, //
                {1, 0, 0, 0, 0, 0}};
        visited = new boolean[4][6];

        maxDepth = dfs(mat, 0, 0, 1);
        System.out.println(maxDepth);

        //test a loop
        mat = new int[][] {{1, 0, 0, 0, 0, 0}, //
                {1, 1, 1, 1, 1, 0}, //
                {1, 0, 0, 0, 1, 0}, //
                {1, 1, 1, 1, 1, 0}};
        visited = new boolean[4][6];

        maxDepth = dfs(mat, 0, 0, 1);
        System.out.println(maxDepth);

        //test problem case
        mat = new int[][] {{1, 0, 1, 1, 0, 0}, //
                {1, 1, 1, 1, 1, 1}, //
                {1, 0, 0, 0, 0, 1}, //
                {1, 0, 0, 0, 0, 0}};
        visited = new boolean[4][6];

        maxDepth = dfs(mat, 0, 0, 1);
        System.out.println(maxDepth);
    }

    static int dfs(int[][] matrix, int startRow, int startCol, int depth) {//added a parameter for the recursion depth here
        visited[startRow][startCol] = true;
        int maxDepth = depth;//the maximum depth is the current recursion depth (until you find a deeper one)
        for (int k = 0; k < 4; k++) {
            int row1 = startRow + rowNbr[k];
            int col1 = startCol + colNbr[k];
            if (isValid(row1, col1)) {
                if (!visited[row1][col1] && matrix[row1][col1] == 1) {
                    int newDepth = dfs(matrix, row1, col1, depth + 1);//find the next cell in the path
                    if (newDepth > maxDepth) {//if the path is deeper than the deepest known path update the length
                        maxDepth = newDepth;
                    }
                }
            }
        }
        return maxDepth;
    }

    static boolean isValid(int row, int col) {
        if (row < 0 || row > totalRows - 1)
            return false;
        if (col < 0 || col > totalCols - 1)
            return false;
        return true;
    }
}