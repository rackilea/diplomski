private int getIntFromPixel(int[] pixel) 
{
    int r = pixel[0];
    int g = pixel[1];
    int b = pixel[2];

    return (r << 16) | (g << 8) | b;
}

// Returns the sub array with upper-left corner at [start_i][start_j] with
// width sub_w and height sub_h.
public int[][] getSubArray(int[][][] pixelArray, int start_i, int start_j
                               , int sub_w, int sub_h)
{       
    int[][] subArray = new int[sub_w][sub_h];

    for (int i = 0; i < sub_w; i++) {
        for (int j = 0; j < sub_h ; j++) {
            subArray[i][j] = getIntFromPixel(pixelArray[start_i + i][start_j + j]);
        }
    }

    return subArray;
}