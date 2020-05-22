public static <T> LispList<T> pickEven(LispList<T> ls) {
    if (ls.isEmpty())
        return ls; // return empty
    LispList<T> tail1 = ls.tail();
    if (tail1.isEmpty())
        return tail1; // return empty
    LispList<T> tail2 = tail1.tail();
    if (tail2.isEmpty())
        return tail1; // return of(ls.tail().head())
    return pickEven(tail2).cons(tail1.head());
}