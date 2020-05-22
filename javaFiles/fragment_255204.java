public void rotateColumn(final int columnNr)
{
    int columnIndex = columnNr - 1;

    // Values of the selected column in a temporary 1D-array
    int[] currentOrder = new int[amountOfRows];
    for (int r = 0; r < amountOfRows; r++)
    {
        currentOrder[r] = matrixArray[r][columnIndex];
    }

    // Rotate the values once counterclockwise
    int[] newOrder = new int[amountOfRows];
    for (int r = 0; r < amountOfRows; r++)
    {
        newOrder[r] = r == amountOfRows - 1
            ? currentOrder[0]
            : currentOrder[r + 1];

        // NOTE: This above is a shorter way for this:
        //if (r == amountOfRows - 1)
        //{
        //    newOrder[r] = currentOrder[0]
        //}
        //else
        //{
        //    newOrder[r] = currentOrder[r + 1]
        //}
    }

    // Replace the column in the matrix with this new ordered column
    for (int r = 0; r < amountOfRows; r++)
    {
        matrixArray[r][columnIndex] = newOrder[r];
    }
}