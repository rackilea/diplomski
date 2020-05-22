public static int findValue (int [] z, int y) //y is the number given by the user that I need to find.
    {
        for (int x = 0; x < z.length ; x++) 
        {
            if ( z[x] == y)
            {
              return x;
            }
        } 
          return -1;
    }