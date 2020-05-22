public static double GetSquareRoot(double n, double low, double high) {
    double errorMargin = 0.001;        
    double sqrt = (low + high) / 2;
    double diff = sqrt*sqrt - n;
    if ( diff > errorMargin)
        return GetSquareRoot(n, low, sqrt);
    if ( -diff > errorMargin)
        return GetSquareRoot(n, sqrt, high);
    return sqrt;
}