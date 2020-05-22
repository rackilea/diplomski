public static void main(String[] args)
{
    int i,j;
    int s=1;
    System.out.println(s + " ");
    for(i=1;i<=6;i++)
    {
        for(j=1;j<=i;j++)
        {
            s=s*11;
        }
        for (char c : String.valueOf(s).toCharArray()) System.out.print(c + " ");
        System.out.println();
        s=1;
    }
}