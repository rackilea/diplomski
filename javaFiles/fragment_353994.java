public static void main (String[] args) 
    {
      Scanner sc=new Scanner(System.in);
      int T=sc.nextInt();

      for(int i=1;i<=T;i++)
      { 
          int count=1;
          int a=sc.nextInt();
          //System.out.print(" ");
          int b=sc.nextInt();
          // System.out.print(" ");
          int k=sc.nextInt();
          long result=(long) Math.pow(a,b);
          if(k!=count)
          {
              while(k!=count)
              {
                  count++;
                  int remainder=(int) (result%10);
                  result=result/10;

              }
          }
          result=result%10;
          System.out.println(result);
      }
}