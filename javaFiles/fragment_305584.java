long mod(long b, long a)
{
    // computes a mod b
    // assumes that b is positive
    return (b + (a % b)) % b;
}