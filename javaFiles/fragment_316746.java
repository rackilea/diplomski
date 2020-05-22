Scanner in=new Scanner(System.in);
    int x=in.nextInt();
    String s = new String[x];

    if (x >=1 && x<= 10000)
    {

        for(int i=0;i<=x;i++)
        {
             s[i]=in.nextLine();

        }

    }

        for(int i=0;i<=x;i++)
        {
             System.out.println(s[i]);
        }