public static void flipVertically(int[][] img) {

    int height = img.length;
    int width = img[0].length;  

    for(int row = 0; row < height/2; row++)
    {
        int [] myrow =  img[row];
        img [row] = img[height - row - 1];

        img[height - row - 1] = myrow;          
    }      
}