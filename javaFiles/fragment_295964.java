public static void fractionSum (int a) 
{
    for (int i = 1; i <= a; i++) 
    {
        if (i != 1)
            System.out.print(" + 1/" + i);
        else 
            System.out.print("1");
    } 
}