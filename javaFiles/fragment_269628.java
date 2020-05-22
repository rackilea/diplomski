public boolean Fire()
{
    if (under.isEmpty())
        return true;
    else
    {
        for (int x = under.size() - 1; x >= 0; x--)
        {
             if (under.get(x).Fire())
                 under.remove(x);

        }

    }

    return false;
}