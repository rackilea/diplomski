public class Test
{
    public static void main(String args[]) {
            int j,i;
            int max=4;
            int n=0;
            for(i=0;i<((max*2)-1);i++)
            {
                    if(i<max)
                     n++;
                    else
                     n--;
                    for(j=1;j<=n;j++)
                    {
                            System.out.print(j+" ");
                    }
                    System.out.println("");
            }
    }
}