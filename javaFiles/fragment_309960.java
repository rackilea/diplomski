class Diagonal {
    static char [][] colorArray = new char [5][5];
    public static void main(String args[])
    {
        for (int i = 0; i < 5; i++ ) {
            // Even rows, including 0th row
            if ((i%2)==0) {
                // Color in locations with even indexes
                for (int j =0; j < 5; j++ ) {
                    if ((j%2)==0) {
                        colorArray[i][j] = 255;
                    }
                }
            } else { // Odd rows
                for (int j =0; j < 5; j++ ) {
                    // Color in locations with odd indexes
                    if ((j%2)!=0) {
                        colorArray[i][j] = 255;
                    }
                }
            }
        }

    }
}