//  Swaps the subimage at row1,col1 with the subimage at row2,col2
private void swapPosition(row1, col1, row2, col2)
{
    BufferedImage temp = pieces[row1][col1];
    pieces[row1][col1] = pieces[row2][col2];
    pieces[row2][col2] = temp;
}