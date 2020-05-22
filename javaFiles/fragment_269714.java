int sum = 0;

int[][] attendance1 = m.getAttendance();
for (int i = 0; i < 3; ++i)
    for (int j = 0; j < 3; ++j)
        sum += attendance1[i][j];

int[][] attendance2 = m2.getAttendance();
for (int i = 0; i < 3; ++i)
    for (int j = 0; j < 3; ++j)
        sum += attendance2[i][j];