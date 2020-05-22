public int[][] getAttendance() {
    int rows = attendance.length();
    int cols = attendance[0].length();
    int[][] copy = new int[rows][cols];

    for(int i = 0; i < rows; i++)
        for(int j = 0; j < cols; j++)
            copy[i][j]=current[i][j];

    return copy;
}