public static void main(String[] args)
    {
        String[] x = {"no", "i", "in", "eye"};
        String[][] y = new String[x.length][];
        for (int i = 0; i <= x.length - 1; i++) //1
        {
            y[i] = new String[x[i].length()]; //2

            for (int j = 0; j < y[i].length; ++j) 
            {
                y[i][j] = x[i]; //3
            }
            System.out.println(Arrays.toString(y[i]));
        }
    }