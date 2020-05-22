int main(String[] args)
{
    int[] values = inputMove();
    placeMove(values[0], values[1]); // <- won't read input any more!
    checkWin(values[0], values[1]);
}