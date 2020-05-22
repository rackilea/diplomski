public static void main(String[] args)
{
    double sum = 0, a = 1;
    int n = Integer.parseInt(args[0]);
    for ( int i = 1; i <= n; i++ )
    {
        a *= i;
        sum = sum + (1.0 / a);
    }
    System.out.print(sum);
}