public static boolean search(int[] keys, int value, int l, int r)
{
    if(l < 0 || r >= keys.length || l>r) return false;
    else
    {
        Random random =   new Random();
        int i       =   l + random.nextInt(r-l);

        if(keys[i] == value) return true;
        else if(keys[i] > value) return search(keys, value, l, i - 1);
        else return search(keys, value, i + 1, r);
    }
}