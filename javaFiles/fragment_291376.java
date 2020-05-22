void calculateSquare(int n)
    {
//      odds descending and even ascending
        int t=n;
        if(n<=0)
            return;
         if(n%2==1)
        {
//          Calculate square now and print it also
            System.out.println(n*n);
            calculateSquare(--n);

        }
        else
        {

            calculateSquare(--n);
            System.out.println(t*t);

        }

    }