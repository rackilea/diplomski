class CommonElements
{
    public static void main(String args[])
    {
        int s1,s2,count=0;
        boolean d = false; //Assign false to it

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter 1st array size");
        s1=sc.nextInt();
        int n1[]=new int[s1];
        System.out.println("Enter "+s1+" nos for 1st array");
        for(int i=0;i<s1;i++)
        {
            n1[i]=sc.nextInt();
        }

        System.out.println("Enter 2nd array size");
        s2=sc.nextInt();
        int n2[]=new int[s2];
        System.out.println("Enter "+s2+" nos for 2nd array");
        for(int i=0;i<s2;i++)
        {
            n2[i]=sc.nextInt();
        }

        System.out.println("\n");
        for(int i=0;i<s1;i++)
        {
            for(int j=0;j<s2;j++)
            {

                if(n1[i]==n2[j])
                {
                    d=true;
                    System.out.println(n1[i]);
                }
                //else NO NEED OF THIS ELSE SECTION AS IF YOUR LAST 
                                    // COMPARISON DO NOT MATCHES THEN IT WILL REASSIGN FALSE VALUE
                //d=false;
            }
        }

        if(d==false)
            System.out.println("there are no common elements");


    }
}