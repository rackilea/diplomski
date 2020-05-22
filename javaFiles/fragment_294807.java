package practiceproblems;

import java.util.ArrayDeque;


public class AlphabetCount {

    private int ofLength;
    private int paths = 0;
    private String[] grid;

    //this is the array that we memoize.  could be hashmap
    private int[][] memoArray;// spec says it initalizes to zero so i am just going with it

    //entry point func
    public int count(String[] grid, int ofLength) {

        //initialize all the member vars
        memoArray = new int[grid[0].length()][grid.length];
        this.grid = grid;
        // this is minus 1 because we already found "A"
        this.ofLength = ofLength - 1;
        paths = 0;
        //saves the previous nodes visited.
        ArrayDeque<int[]> goodPathStack = new ArrayDeque<int[]>();


        long startTime = System.currentTimeMillis();
        for (int j = 0; j < grid.length; j++) {
            for (int index = grid[j].indexOf('A'); index >= 0; index = grid[j].indexOf('A', index + 1)) {
                //kinda wasteful to clone i would think... but easier because it stays in its stack frame
                recursiveFind(goodPathStack.clone(), 0, index, j);

            }

        }
        System.out.println(System.currentTimeMillis() - startTime);
        //if we have more than a bil then just return a bil
        return paths >= 1_000_000_000 ? 1_000_000_000 : paths;
    }

    //recursive func
    private void recursiveFind(ArrayDeque<int[]> fullPath, int layer, int x, int y) {

        //debugging
        System.out.println("Preorder " + layer + " " + (x) + " " + (y));

        //start pushing onto the path stack so that we know where we have been in a given recursion
        int[] pair = { x, y };
        fullPath.push(pair);

        if (paths >= 1_000_000_000) {
            return;

            //we found a full path 'A' thru length
        } else if (layer == this.ofLength) {

            paths++;
            //poll is just pop for deques apparently.
            // all of these paths start at 'A' which we find manually. so pop last.
            // all of these paths incluse the last letter which wouldnt help us because if
            // we find the last letter we already know we are at the end.
            fullPath.pollFirst();
            fullPath.pollLast();

            //this is where we save memoization info
            //each node on fullPath leads to a full path
            for (int[] p : fullPath) {
                memoArray[p[0]][p[1]]++;
            }
            return;

        } else if (memoArray[x][y] > 0) {

            //this is us using our memoization cache
            paths += memoArray[x][y];
            fullPath.pollLast();
            fullPath.pollFirst();
            for (int[] p : fullPath) {
                memoArray[p[0]][p[1]] += memoArray[x][y];
            }

        }

//      else if (memoStack.containsKey(key)) {
//          for (int[] path : memoStack.get(key)) {
//              recursiveFind(fullPath,layer + 1, path[0], path[1]);
//          }
//      } 

        else {

            int xBound = grid[0].length();
            int yBound = grid.length;

            //search in all 8 directions for a letter that comes after the one that you are on.
            for (int dx = -1; dx <= 1; ++dx) {
                for (int dy = -1; dy <= 1; ++dy) {
                    if (dx != 0 || dy != 0) {
                        if ((x + dx < xBound && y + dy < yBound) && (x + dx >= 0 && y + dy >= 0)) {
                            if (grid[y].charAt(x) + 1 == grid[y + dy].charAt(x + dx)) {

                                recursiveFind(fullPath.clone(), layer + 1, x + dx, y + dy);

                            }
                        }

                    }

                }
            }
        }

        // memoStack.putIfAbsent(key, newPaths);

        // memo thought! if one runs layer, x and y are the same then you can use a
        // previous run

    }

}