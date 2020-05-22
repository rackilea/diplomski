int l = 2;
void permute(String str, int n)
{
    for(int i=n;i<=l;i++)
    {
        if(n==l)
        {
            System.out.println(swap(str,n,i));
            return;
        }
        else
            permute(swap(str,n,i),n+1);
    }
}