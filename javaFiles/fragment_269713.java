int[][] attendance1 = m.getAttendance();
int[][] attendance2 = m2.getAttendance();
int[][] sum = new int[3][3];

for (int i = 0; i < 3; ++i)
    for (int j = 0; j < 3; ++j)
        sum[i][j] = attendance1[i][j] + attendance2[i][j];