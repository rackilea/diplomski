for (int col = 0; col < assignments.length; col++)
{
    for (int row = 0; row < assignments[col].length; row++) {
         assignAvgArray[row] += assignments[row][col];
    }

    assignAvgArray[col] = (assignAvgArray[col]/5);
}