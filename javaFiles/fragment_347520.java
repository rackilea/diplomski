public int lastNonRepeat( int[] a )
{
    HashMap map = new HashMap();
    int lastIndex = 0;
    for( int i = 0; i < a.length; i++ )
    {
        if( !map.containsKey(a[i]) )
        {
            map.put(a[i],true);
            lastIndex = i;
        }
    }
    return lastIndex;
}