public void printStarsDiamond(int d) 
{
    for (int i = 1; i < d; i = i + 2) 
    {
        for (int j = 0; j < (d - i) / 2; j++)
        {
            System.out.print(" ");
        }

        for (int k = 0; k < i; k++) 
        {
            System.out.print("*");
        }
        System.out.println();
    }
    for (int i = d-1; i > 0; i = i - 2) 
    {
        for (int j = 0; j < (d - i) / 2; j++)
        {
            System.out.print(" ");
        }
        for (int k = 1; k <= i; k++) 
        {
            System.out.print("*");
        }
        System.out.println();
    }