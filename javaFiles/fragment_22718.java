public class Solution {
    public static int biggestHourglass(int[][] buffer){

        int result = -256; 
        int currentSize = 0;

        for (int x=0; x<4; x++){
            for (int y=0; y<4; y++){
                currentSize = (buffer[x+2][y] + buffer[x+2][y+1] + buffer[x+2][y+2]
                                        + buffer[x+1][y+1]
                         + buffer[x][y] + buffer[x][y+1] + buffer[x][y+2]);
                if (currentSize > result) { result = currentSize;}
            }
        }

        return result;
    }
}