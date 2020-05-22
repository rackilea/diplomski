for (int f = 2; f < m; f += 2)
{
    if (n % f == 0 && m % f != 0)
    {
        return false;
    }
}
return true;