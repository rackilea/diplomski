int n=4;
    int result=1;
    for(int i=1;i<=n;i++)
    {
       result = result * i;
       System.out.print("1*");
       for(int j=1;j<i;j++)
       {
           System.out.print(j+"*");
       }
       System.out.println(i+"="+result);
    }