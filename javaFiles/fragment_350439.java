int p=0;
    int c=1;
    int sum=0;
    String fibo="";

    for(int i=0;i<10;i++)
        {
            sum =c+p;
            //System.out.println(sum);
            p=c;
            c=sum;
            fibo=fibo+sum;

        }
        return fibo;