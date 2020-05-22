public static <T> LispList<T> pickOdd(LispList<T> ls) {
    if (ls.isEmpty())
        return ls; // return empty
    LispList<T> tail1 = ls.tail();
    if (tail1.isEmpty())
        return ls; // return of(ls.head())
    LispList<T> tail2 = tail1.tail();
    if (tail2.isEmpty())
        return tail2.cons(ls.head()); // return of(ls.head())
    return pickOdd(tail2).cons(ls.head());
}