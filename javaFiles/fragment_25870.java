static long get(long n,long i,long digit)
    {
      long p;
      p=(long)Math.pow(10,i-1);
      n=n/p;
      return n%10;
    }

static boolean check_pal(long n)
    {
      long digit;
      digit=(long) (Math.log10(n)+1);
      long a=0,b=0,i,j,p;
      long sum=0;
      for(i=1,j=digit-1 ; i<=digit ; i++,j-- )
      {
        a=(long) get(n,i,digit);
        sum+=a*Math.pow(10,j);
      }
      if(sum==n)
        return true;
      else
        return false;
    }

static long reverse(long n)
    {
        long digit;
        digit=(long) (Math.log10(n)+1);
        long a=0,b=0,i,j,p;
        long sum=0;
        for(i=1,j=digit-1 ; i<=digit ; i++,j-- )
        {
            a=(long) get(n,i,digit);
            sum+=a*Math.pow(10,j);
        }
        return n+sum;
    }