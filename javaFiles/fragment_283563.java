private static boolean equal(final Object[] a1, final Object[] a2)
{
    return _equal(a1, a2, new HashSet<ArrayPair>());
}

private static boolean _equal
    (final Object[] a1, final Object[] a2, final Set<ArrayPair> pairs)
{
    if(a1 == a2)
        return true;
    if(a1.length != a2.length)
        return false;

    if(! pairs.add(new ArrayPair(a1, a2)))
    {
        // If we're here, then pairs already contained {a1,a2}. This means
        // either that we've previously compared a1 and a2 and found them to
        // be equal (in which case we obviously want to return true), or
        // that we're currently comparing them somewhere higher in the
        // stack and haven't *yet* found them to be unequal (in which case
        // we still want to return true: if it turns out that they're
        // unequal because of some later difference we haven't reached yet,
        // that's fine, because the comparison higher in the stack will
        // still find that).

        return true;
    }

    for(int i = 0; i < a1.length; ++i)
    {
        if(a1[i] == a2[i])
            continue;
        if(a1[i] == null || a2[i] == null)
            return false;
        if(a1[i].equals(a2[i]))
            continue;
        if(! (a1[i] instanceof Object[]) || ! (a2[i] instanceof Object[]))
            return false;
        if(! _equal((Object[]) a1[i], (Object[]) a2[i], pairs))
            return false;
    }

    return true;
}

private static final class ArrayPair
{
    private final Object[] a1;
    private final Object[] a2;

    public ArrayPair(final Object[] a1, final Object[] a2)
    {
        if(a1 == null || a2 == null)
            throw new NullPointerException();

        this.a1 = a1;
        this.a2 = a2;
    }

    @Override
    public boolean equals(final Object that)
    {
        if(that instanceof ArrayPair)
            if(a1 == ((ArrayPair)that).a1)
                return a2 == ((ArrayPair)that).a2;
            else 
                if(a1 == ((ArrayPair)that).a2)
                    return a2 == ((ArrayPair)that).a1;
                else
                    return false;
        else
            return false;
    }

    @Override
    public int hashCode()
        { return a1.hashCode() + a2.hashCode(); }
}