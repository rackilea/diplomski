for (int col = 0; col < assignments[0].length; col++)
{
    for (int row = 0; row < assignments.length; row++) {
         assignAvgArray[row] += assignments[row][col];
    }

    assignAvgArray[col] = (assignAvgArray[col]/5);
}