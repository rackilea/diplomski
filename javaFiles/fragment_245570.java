import java.util.*;

public class MaximumPath {

    // object to store both path and total
    public static class Pair {
        public ArrayList a;
        public int b;

        public Pair(ArrayList a, int b) {
            this.a = a;
            this.b = b;
        }
    };

    public static Pair maxSum(int grid[][]){
        int r = grid.length - 1;        // bottom row #
        int c = grid[0].length - 1;     // rightmost column #
        Pair max = null;
        for (int i=0; i <= c; i++){
            Pair val = maxSum(grid, r, i); // call recursive method for each of the bottom row cells
            if (max == null || val.b > max.b) max = val;
        }
        return max;
    }

    public static Pair maxSum(int grid[][], int row, int col)
    // recursive method to find largest sum path to row,col, coming downwards from top
    {
       if (col < 0 || row < 0 || row > grid[0].length || col > grid.length){           
           return new Pair(new ArrayList(), 0);           
       }else{
           // take the path pair with the max value so far
           Pair p = maxPair(maxSum(grid, row-1, col-1),         // top left
                            maxSum(grid, row-1, col),           // top
                            maxSum(grid, row-1, col+1) ) ;      // top right)            
           // add the current path value and total to the path
           p.a.add(grid[row][col]);
           p.b += grid[row][col];           
           return p;
       }       
    }

    public static Pair maxPair(Pair x, Pair y, Pair z)
    {
        if(x.b > y.b){
            return (x.b > z.b)? x : z;
        }else{
            return (y.b > z.b)? y : z;   
        }        
    }

    public static void main(String[] args){
        int[][] grid = {{2, 5, 17, 12, 3}, 
                        {15, 8, 4, 11, 10}, 
                        {9, 18, 6, 20, 16}, 
                        {14, 13, 12, 1, 7}};    
        Pair p = maxSum(grid);
        System.out.println("Max sum is " + p.b);
        System.out.println("Path is " + p.a);
    }
}