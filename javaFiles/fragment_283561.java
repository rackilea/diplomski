boolean equal(final Object[] o1, final Object[] o2)
{
    return _equal(o1, o2, new ArrayList<Object>(), new ArrayList<Object>());
}

private static boolean _equal(final Object[] o1, final Object[] o2,
                                 final List<Object> xs, final List<Object> ys)
{
    if(o1.length != o2.length)
        return false;

    xs.add(o1);
    ys.add(o2);
    try
    {
        for(int i = 0; i < o1.length; i++)
        {
            if(o1[i] == null && o2[i] == null)
                continue;
            if(o1[i] == null || o2[i] == null)
                return false;
            if(o1[i].equals(o2[i]))
                continue;
            if(! (o1[i] instanceof Object[]) || ! (o2[i] instanceof Object[]))
                return false;

            final int idx1 = xs.lastIndexOf(o1[i]);

            if(idx1 >= 0 && idx1 == ys.lastIndexOf(o2[i]))
                continue;

            if(! _equal((Object[])o1[i], (Object[])o2[i], xs, ys))
                return false;
        }

        return true;
    }
    finally
    {
        xs.remove(xs.size() - 1);
        ys.remove(ys.size() - 1);
    }
}