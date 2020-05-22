boolean[] seen = new boolean[9];

for (int i = 0; i < 3; i++)
    for (int j = 0; j < 3; j++)
        if (seen(sudokuBoard[referenceColumn+i][referenceRow+j])) return false;
        else seen[sudokuBoard[referenceColumn+i][referenceRow+j]) = true;
return true;