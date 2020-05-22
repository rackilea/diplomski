private static ConcurrentHashMap<Integer, Multiton> instances = new ConcurrentHashMap<Integer, Multiton>();

public static Multiton getInstance(int which) 
{
    Multiton result = instances.get(which);

    if (result == null) 
    {
        Multiton m = new Multiton(...);
        result = instances.putIfAbsent(which, m);

        if (result == null)
            result = m;
    }

    return result;
}