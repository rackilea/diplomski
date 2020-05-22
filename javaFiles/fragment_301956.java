ArrayList<Object> list = new ArrayList<Object>(Arrays.asList(1, 2, 3, 4, 4.5, 4.4, "NA", "NA", "NA"));
    double num , max  = Float.MIN_VALUE;
    for (Object item : list)
    {
        if (item instanceof Integer)
        {
            num  =(int)item + 0.0;
        }
        else
        {
            if(item instanceof String)
            {
                // don't do anything - skip 
                continue ;
            }
            else
            {
                // is a double
                num = (double)(item) ;

            }
        }
        if(num >= max)
        {
            max = num ;
        }
    }
    System.out.println(max);