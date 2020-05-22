int[][] x = new int[10][3]; // array filled with zeros
int time = 25;
for (int i = 0; i < x.length; ++i) {
    int[] row = x[i];
    row[2] = time;
    time += 25;
}