int horse= 5;
    int w;
    //loop from 1 to 5
    for (w =1; w <= horse; w++)
    {
        System.out.println(w + " The first loop");
    }

    int test= horse + 4;
    //loop from 6 to 9
    //here the initial value of w is 6 from the previous loop
    for (; w <= test; w++)
    {
        System.out.println(w + " The second loop");

    }

    int try0 = test + 6;
    //loop from 10 to 15
    //here the initial value of w is 10 from the previous loop
    for (; w <= try0; w++)
    {
        System.out.println(w + " The third loop");
    }