public static <T> T[] select(T[] ts, int... indecies) {
    T[] copy = (T[]) new Object[indecies.length];
    for (int i = 0; i < indecies.length; i++)
         copy[i] = ts[indecies[i]];
    return copy;
}