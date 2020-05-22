public static <R> int countGreaterThan(Integer[] anArray, Integer elem) {
    int count = 0;
    for (Integer e : anArray)
        if (e > elem)
            ++count;
    return count;
}