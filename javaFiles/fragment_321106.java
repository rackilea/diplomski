int[][] matrix = ...;
int[][] submatrix = ...;

loopX: for (int x = 0; x < matrix.length - submatrix.length + 1; ++x)
loopY: for (int y = 0; y < matrix[x].length - submatrix[0].length + 1; ++y)
{
    for (int xx = 0; xx < submatrix.length; ++xx)
    for (int yy = 0; yy < submatrix[0].length; ++yy)
    {
        if (matrix[x + xx][y + yy] != submatrix[xx][yy])
        {
            continue loopY;
        }
    }

    // Found the submatrix!
    System.out.println("Found at: " + x + " " + y);
    break loopX;
}
System.out.println("Done");