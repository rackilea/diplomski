for(int i=n-1;i>=0;i--)
    {
        for(int a=0;a<(n-(i+1));a++)
        {
            System.out.print(" ");
        }
        System.out.print("*");
        for(int b=0; b<(i*2);b++)
        {
            System.out.print("-");
        }
        System.out.print("*");
        System.out.println();
    }