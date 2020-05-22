public static void IniBoard(String[][] TicTable)
{
    for(String[] TicTable1 : TicTable)
    {
        for(int c = 0; c < TicTable[0].length; c++)
        {
            TicTable1[c] = "-";
        }
    }
}

public static void PrintBoard(String[][] TicTable)
{
    for(String[] TicTable1 : TicTable)
    {
        for(int c = 0; c < TicTable[0].length; c++)
        {
            System.out.print(TicTable1[c]);
        }
        System.out.println("");
    }
}