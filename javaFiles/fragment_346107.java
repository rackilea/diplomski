public class Simple2DArray {

public static void main(String[] args) {

    int[][] grid = fill();

    System.out.println(biggest(grid, 20));

}

public static int[][] fill()
{
    int[][] grid = new int[5][5];
    for(int r=0;r<grid.length;r++)
    {
        for(int c=0;c<grid[r].length;c++)
        {
            grid[r][c] = (int)(Math.random()*100);
        }
    }

    System.out.println("Input 2D");

    for(int r=0;r<grid.length;r++)
    {
        for(int c=0;c<grid[r].length;c++)
        {
            System.out.print(grid[r][c]);
            System.out.print("\t");
        }

        System.out.println("");
    }

    return grid;
}

public static int biggest(int[][] grid, int big)
{
    if (grid != null) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] > big) {
                    big = grid[r][c];
                }
            }
        }
    }

    return big;
}

}