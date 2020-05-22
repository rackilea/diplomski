public static int nextPrime(int n)
    {
    int num = (int)(1+Math.random()*n);  // other generator

 // TRACE HERE
    System.out.println("START:"+num);

    boolean prime=false;

    // CHANGE HERE
    if (num==2)
        {
        return (num);
        }   
        else
        {
        int i = 2;
        int c = 0;

        // CHANGE HERE
        while ((i < num-1)&&(prime==false))
            {
            // Not prime => next one
            if( (num % i) == 0)
                {
                // TRACE HERE
                System.out.println("YOU LOSE: :"+num+" divided by "+i);

                c=c+1;
                } 

            if((c==0)&&(i==(num-1)))
                {
                prime=true;

                // TRACE HERE
                System.out.println("BINGO:"+num);

                // CHANGE HERE
                break;
                }

            if(c>=1)
                {
                // SAME PLAYER LOOP AGAIN
                num = (int)(1+Math.random()*n);

                // TRACE HERE
                System.out.println("RESTART:"+num);

                i=1;

                // CHANGE HERE
                c=0;
                }
        i=i+1;
        }
    }
    return (num);
    }