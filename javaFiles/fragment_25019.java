public class BiDiMap<T1, T2> {
    private final Map<T1, T2> forwardMap = new HashMap<T1, T2>();
    private final Map<T2, T1> reverseMap = new HashMap<T2, T1>();

    public void put(T1 t1, T2 t2) {
        T2 oldT2 = forwardMap.put(t1, t2);
        T1 oldT1 = reverseMap.put(t2, t1);
    }
    public void remove(T1 t1, T2 t2) {
        T2 currentT2 = forwardMap.get(t1);
        if ( currentT2 != t2 ) {
            // This is an error.
        }
        T1 currentT1 = reverseMap.get(t2);
        if ( currentT1 != t1 ) {
            // Also an error.
        }
        forwardMap.remove(t1);
        reverseMap.remove(t2);
    }
    public T2 getForward(T1 t1) {
        return forwardMap.get(t1);
    }
    public T1 getReverse(T2 t2) {
        return reverseMap.get(t2);
    }
}