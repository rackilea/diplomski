public static void main(String[] args) {
        MineSweeper ms = new MineSweeper(9,9);
        int test;
        // remove code here
        test = ms.tile[0][0].getNeighbours();
        System.out.println("Test: " + test);
    }

public class MineSweeper {
    Tile tile[][];

    MineSweeper(int x,int y) {
        tile = new Tile[x][y];
        // create Tiles here
        for (int i=0;i<x;i++)
            for (int j=0;j<y;j++)
                tile[i][j]=new Tile();
    }
}