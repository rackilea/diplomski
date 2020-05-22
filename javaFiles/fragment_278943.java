public class Test {
    public static void main(String[] args) {
        int x = 2;
        int y = 2;
        int idx = 1;
        int[][] array = new int[x][y];
        int yUpIdx = y-1;
        int yDownIdx = 0;
        int xLeftIdx = 0;
        int xRightIdx = x-1;


        while (idx < x*y) {
            for (int i = xLeftIdx; idx <= x*y && i <= xRightIdx; i++) {
                array[i][yDownIdx] = idx++;
            }
            yDownIdx++;
            for (int j = yDownIdx; idx <= x*y &&  j <= yUpIdx; j++) {
                array[xRightIdx][j] = idx++;
            }
            xRightIdx--;
            for (int i = xRightIdx; idx <= x*y &&  i>=xLeftIdx ; i--) {
                array[i][yUpIdx] = idx++;
            }
            yUpIdx--;
            for (int j = yUpIdx; idx <= x*y &&  j>=yDownIdx ; j--) {
                array[xLeftIdx][j] = idx++;
            }
            xLeftIdx++;
        }
        for (int j = 0; j < y; j++) {
            for (int i = 0 ; i < x; i++) {
                if ((array[i][j]+"").length() < 2) System.out.print(" "); 
                System.out.print(array[i][j]+" ");
            }
            System.out.println("");
        }
    }