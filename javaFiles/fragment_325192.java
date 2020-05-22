public static void main (String[] args) {
    double[] cdf = {0.1, 0.5, 0.7, 0.8, 1.0};
    double random = 0.75;  // generate randomly between zero and one
    int el = Arrays.binarySearch(cdf, random);
    if (el < 0) {
        el = -(el + 1);
    }
    System.out.println(el);
}