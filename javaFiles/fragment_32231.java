public static void main(String[] args) 
{
    printPyramid(7);
}

public static void printPyramid(int lines)
{
    if (lines > 1)
    {
        printPyramid(lines-1);
    }
    printLine(lines);
    System.out.println("");
}

public static void printLine(int level)
{
    if (level > 0)
    {
        System.out.print("*");
        printLine(level-1);
    }
}