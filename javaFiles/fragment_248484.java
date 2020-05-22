int[] array = new int[542];
    int m;

    int primumnum;
    String r = "";


    for (m=0; m<=542; m++)
    {
        int counter = 0;

        for(primumnum=m; primumnum>=1; primumnum--)
        {
            if(m % primumnum == 0)
            {
                counter = counter + 1;
            }
        }
        if(counter == 2)
        {
            r = r + m + " ";
            //r+= array[m];

        }

    }