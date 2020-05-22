outer:  for (int i = 2; i<=n;i++)
    {
        for(int j = 2; j<i;j++)
        {
            if(i%j==0)
            {   
                continue outer; // skip the rest of outers loop and go to its start
            }
        }
        System.out.println("Prime Number " + i); //this will not get run 
                                                 //when the continue statement is hit
    }