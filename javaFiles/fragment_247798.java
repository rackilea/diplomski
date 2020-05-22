public static String GetWinner(String[][] TicTable)
{
    //your code here:
    return null;
}

public static void main(String[] args)
{
    String Gp1 = "", Gp2 = "";
    String[][] TicTable = new String[3][3];
    String Player1 = "X", Player2 = "O";
    String winner = null;
    int row1 = 0, row2 = 0;
    int col1 = 0, col2 = 0;

    IniBoard(TicTable);
    while(winner == null)
    {
        PrintBoard(TicTable);
        Player1(Player1, row1, col1, TicTable);
        Player2(Player2, row2, col2, TicTable);
        winner = GetWinner(TicTable);
    }
}