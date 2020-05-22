outer:  for (int i = 2; i<=n;i++)
    {
        for(int j = 2; j<i;j++)
        {
            if(i%j==0)
            {   
                break; // stop running the inner loop
            }
        }
        System.out.println("Prime Number " + i); //this still gets run regardless of break
    }