public class LinkedVar<T> {

    public LinkedVar() {
        fromto = new HashMap<T,T>();
        tofrom = new HashMap<T,T>();
    }

    public boolean put(T a, T b)
    {
        if(fromto.containsKey(a) || tofrom.containsKey(b))
            return false;
        fromto.put(a, b);
        tofrom.put(b, a);
        return true;
    }

    public T get(T key)   
    {
        for(Map<T,T> m: Arrays.asList(fromto, tofrom))
            if(m.containsKey(key)) return m.get(key);
        return null;
    }

    private Map<T,T> fromto;
    private Map<T,T> tofrom;

}