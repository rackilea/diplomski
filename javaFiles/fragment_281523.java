public static int GCD(int a, int b)
    {
        while (b != 0)
        {
            int r = a%b;
            System.out.println("(" +a+ "," +b+ ")");
            b = r;
            a = b;
            if(b == 0)
            {
                return a;
            }
        }
        return 0;
    }