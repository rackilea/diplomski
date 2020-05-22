for (int i = 1; i <= ulen; i ++)
{
    if (w[0].wish <= i)
    {
        used[0] = true;
        search(0, i, 1);
        used[0] = false;
    }
}