int[][] x = new int[10][3]; // 2D array filled with zeros
int time = 25;
for (int[] row : x) {
    row[2] = time;
    time += 25;
}