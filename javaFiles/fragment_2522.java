public static double randomRecursion(double a, double b, int i) {
    if (i > 0) { 
        b = ((1 / a) - a) * b;
        i = i - 1;
        // return was missing here
        return RandomRecursion(a, b, i);
    }
    return b;
}