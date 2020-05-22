public static String convert(String bin)
    {

        //System.out.println( "The Gray Equivalent Is: ");
        char[] b = bin.toCharArray();
        StringBuilder g = new StringBuilder(); // Use StringBuilder
        g.append(b[0]);
        //System.out.print(g[0]);
        for(int i=1;i<b.length;i++)
        {
            int val = (int)b[i-1] ^(int) b[i]; // use exclusive-or( ^ ) 
            if(val == '2')
            {
                //System.out.print(0);
                g.append(0);
                i++;
                continue;
        }

        //System.out.print(g[i] - 0);
        g.append(val);
    }

    String gray = String.valueOf(g);
    return gray;
}