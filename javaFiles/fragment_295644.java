public void drawMaze(int numRows, int numCols) {
    String[][] mazeArray = new String[numRows][numCols];
    Random random = new Random();
    for (int i = 0; i < mazeArray.length; i++) {
        for (int j = 0; j < mazeArray[i].length; j++) {
            int result = 1 + random.nextInt(200);
            if (result > 100) {
                mazeArray[i][j] = "#";
            } else {
                mazeArray[i][j] = Integer.toString(result);
            }
        }
    }
    //starting point
    mazeArray[0][0] = "S";
    //destination point
    mazeArray[numRows-1][numCols-1] = "D";
    for (int i = 0; i < mazeArray.length; i++) {
        for (int j = 0; j < mazeArray[i].length; j++) {
            System.out.print(String.format("%4s", mazeArray[i][j]));
        }
        System.out.println();
    }
}