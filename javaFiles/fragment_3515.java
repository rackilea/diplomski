public void nonRecursivePrint()
  {
    nonRecursivePrint(n, true);
  }

  public void nonRecursivePrint(int n, boolean upsideDown)
  {
    if (!upsideDown)
    {
      for (int j=0; j<(n+1); j++)
      {
        for (int i=0; i<(j); i++)
        {
          System.out.print(binom(j - 1, i) + (j == i + 1 ? "\n" : " "));
        }
      }
    }
    else
    {
      for (int j=n; j>0; j--)
      {
        for (int i=0; i<(j); i++)
        {
        System.out.print(binom(j - 1, i) + (j == i + 1 ? "\n" : " "));
        }
      }
    }       
  }