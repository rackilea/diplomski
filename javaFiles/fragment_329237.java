int row = 5, col = 5;
    for(int x=0; x<row; x++)
    {
        for(int y=0; y<col; y++)
            if ( x % 2 == 0)
                System.out.print("* ");
            else
                System.out.print(" *");     
        System.out.println("");
    }