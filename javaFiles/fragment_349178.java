public long power(int x, int n) 
{   
    if (x < 0 && n < 0)
    {
        // Use exceptions to report errors, not System.exit
        throw new IllegalArgumentException("x and/or n are negative");
    }
    return x * (long) n;
}