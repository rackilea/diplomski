@SafeVarargs
public static final  <@Nullable E extends Comparable<E>> E max(final E... elements) {
    E result = null; // no error
    for(final E e : elements) {
        if(result == null || result.compareTo(e) < 0) {
            result = e;
        }
    }
    return result;
}