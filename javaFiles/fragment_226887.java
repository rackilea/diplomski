public static void main (String[] args) throws java.lang.Exception
{
    makeTriangle(5);
    // change the above line if you need to input the number (5) from the user
}

public static void makeTriangle(Integer base_size)
{
    for(int x = 1; x < base_size + 1; x++)
    {
        System.out.print(makeRow(x, base_size));
        System.out.println();
    }
}

public static String makeRow(Integer row_num, Integer base)
{
    String row = "";
    for(int x = base; x >= 0; x--) 
    {
        if (x < row_num) { row += "*"; }
        else row += " ";
    }
    return row;
}