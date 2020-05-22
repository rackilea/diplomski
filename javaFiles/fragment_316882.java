void findFactors(int[] primeDivisors, int[] multiplicity, int currentDivisor, long currentResult) {
    if (currentDivisor == primeDivisors.length) {
        // no more balls
        System.out.println(currentResult);
        return;
    }
    // how many times will we take current divisor?
    // we have to try all options
    for (int i = 0; i <= multiplicity[currentDivisor]; ++i) {
        findFactors(primeDivisors, multiplicity, currentDivisor + 1, currentResult);
        currentResult *= primeDivisors[currentDivisor];
    }
}