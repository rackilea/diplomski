public static <POTATO> int countGreaterThan(POTATO[] anArray, POTATO elem) {
    int count = 0;
    for (POTATO e : anArray)
        if (e > elem)  // compiler error
            ++count;
    return count;
}