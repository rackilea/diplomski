void print(int a, int b, int c)
{
    int max = Math.max(a, Math.max(b, c));
    for(int i = max; i > 0; i--)
    {
        System.out.print(a >= i ? "*" : " ");
        System.out.print(b >= i ? "*" : " ");
        System.out.print(c >= i ? "*" : " ");
        System.out.println();
    }
}