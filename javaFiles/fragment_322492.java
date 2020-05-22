public MyList reverse_new()
{
    int[] l = new int[t.length];
    int lunghezzo = t.length - 1;
    for(int x = 0 ; x < t.length ; x++)
    {
        l[x] = t[lunghezzo - x];
    }

    return new MyList(l);
}