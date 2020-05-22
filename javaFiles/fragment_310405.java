int[] row1 = new int[3];
int[] row2 = new int[3];
int[] row3 = new int[3];

// Fill your rows with numbers
for (int i = 0; i < 3; i++)
{
    row1[i] = (int)(Math.random() * 2);
    row2[i] = (int)(Math.random() * 2);
    row3[i] = (int)(Math.random() * 2);
}

printRow(row1);
printRow(row2);
printRow(row3);