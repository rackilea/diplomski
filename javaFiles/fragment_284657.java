int main(String[] args)
{
    int[] values = inputMove();
    while(values[0] >= rows || values[1] >= columns)
    // by the way: you do not check for NEGATIVE input!!!
    {
        System.out.println("This space is off the board, try again.");
        values = inputMove();
    }
    placeMove(values[0], values[1]); // <- won't read input any more!
    checkWin(values[0], values[1]);
}