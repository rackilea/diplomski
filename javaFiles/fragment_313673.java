/**
 * Returns true iff two arrays of the same component type and
 * length are passed in.
 */
public static boolean pseudoArrayEquals(Object a, Object b){
    if(a==null||b==null||!a.getClass().isArray()||!b.getClass().isArray())
        throw new IllegalArgumentException("Expected two arrays");
    return a.getClass() == b.getClass()
           && Array.getLength(a) == Array.getLength(b);
}