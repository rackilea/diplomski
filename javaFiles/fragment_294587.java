while (child <= n)
{
    if (child < n && tab[child] < tab[child+1])
    {
        child = child+1;
    }