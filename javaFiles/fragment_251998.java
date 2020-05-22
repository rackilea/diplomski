public void tail(int n)         |     public void head(int n)
{                               |     {
    if(n == 1)                  |         if(n == 0)
        return;                 |             return;
    else                        |         else
        System.out.println(n);  |             head(n-1);
                                |
    tail(n-1);                  |         System.out.println(n);
}                               |     }