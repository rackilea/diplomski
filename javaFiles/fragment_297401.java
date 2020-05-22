public long Recursiv(int n)
{
    if (0 == n)
        return 0;
    else if (1 == n)
        return 1;
    else
        return this.Recursiv(n - 1) + this.Recursiv(n - 2)
}