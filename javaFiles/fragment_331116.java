public static boolean isDivisibleBy3(int n)
{
    if(n == 0) return true;
    if(n < 0) return false;
    return isDivisibleBy3(n - 3);
}