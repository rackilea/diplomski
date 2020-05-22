public static int power(int x, int n)
{
    int total = 1;
    for(int i = 0; i < n; i++) // i can be declared here directly
    {   
        total = (x * total);
    }
    return total; // total remains 1 if n = 0   
}