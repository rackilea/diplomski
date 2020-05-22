public class Fill
{

    public static void fill(int[][] map, int col, int row, int color,int oldColor) 
    {

        System.out.println("row is: "+row+"col is:"+col);
        if ((row <= 0) || (row >= map.length) || (col <= 0) || (col >= map.length) ) return; 

        if(map[row][col]==color)
            return;

        if(map[row][col]==oldColor)
        {
            map[row][col]=color;
        }

        if(col+1<=map.length) {
            fill(map, col+1, row,color,oldColor);
        }

        if((col-1)<=0) { 
            fill(map,col-1, row,color,oldColor);
        }

        if(row+1<=map.length) {
            fill(map, col, row+1,color,oldColor);
        }

        if((row-1)<=0) {
            fill(map, col, row-1,color,oldColor);
        }

    } 


    public static void main(String pArgs[])
    {
        int[][] map={{4,0,0,0},
             {0,4,0,0},
             {0,4,0,0},
             {0,4,0,0}};

        printMap(map);
        fill(map,1,1,9,4);// calling to function.
        printMap(map);
    }

    static void printMap(int[][] map)
    {
        for (int i=0; i < 4; i++) {
            System.out.print("{");
            for (int j=0; j<4; j++) {
                System.out.print( map[i][j] + "," );
            }
            System.out.println("}");
        }
    }
}