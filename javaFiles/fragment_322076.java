public static void main(String[] args) 
{
    int[][] mat={{2,41,3,14},
                 {2,1,24,7},
                 {2,15,10,54},
                 {63,22,2,4}};

    int[][] path={{0,0,0,0},
                  {0,0,0,0},
                  {0,0,0,0},
                  {0,0,0,0}};

    if ( findSum(mat,22,path) ) print(path);
    else System.out.println("No path found");
}
public static boolean findSum (int mat[][], int sum, int path[][])
{
    return startPath(mat, sum, path, -1, 0);
}

// Recursively check every possible starting point
public static boolean startPath(int mat[][], int sum, int path[][], int y, int x)
{
    // Iterate y, goto next column if necessary
    if (++y == mat.length) {
        y = 0;
        ++x;
    }

    if (x == mat[0].length) // Bounds check
        return false;

    if (findSum(mat, sum, path, y, x)) // We've found a successful start point!
    {
        System.out.println("A successful path starts at " + x + ", " + y);
        return true;
    }

    return startPath(mat, sum, path, y, x); // We'll have to keep looking
}

public static boolean findSum (int mat[][], int sum, int path[][], int i, int j)
{
    if(i==mat[0].length || j==mat[1].length || i<0 || j<0) // Bounds check
        return false;

    if (path[i][j] == 1) // Backtracking check
        return false;

    sum -= mat[i][j]; // Decrement sum

    if (sum >= 0) { // More to go? look around
        path[i][j] = 1;

        if (sum == 0) return true; // We made it!

         // If any path finds the end, don't try other paths
        boolean result = findSum(mat, sum, path, i+1, j);
        if (result) return true;
        result = findSum(mat, sum, path, i, j+1);
        if (result) return true;
        result = findSum(mat, sum, path, i-1, j);
        if (result) return true;
        result = findSum(mat, sum, path, i, j-1);

         // There was no successful paths, this is a dead end
        if (!result) path[i][j] = 0;
        return result;
    } else { // We're negative, overshot it
        return false;
    }
}

private static void print(int[][] arr)
{
    for(int i=0;i<arr[0].length;i++)
    {
        for(int j=0;j<arr[0].length;j++)
        {
            System.out.print(arr[i][j]+" ");
        }
        System.out.println();
    }
}