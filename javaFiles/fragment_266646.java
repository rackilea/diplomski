public int root(int i)
{
    while(i != id[i])
    {
        id[i] = id[id[i]];   // this line represents "path compression"
        i = id[i];
    }
    return i;
}