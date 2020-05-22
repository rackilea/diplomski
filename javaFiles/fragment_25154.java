public int power(int x, int exponent) {
    int result = 1;
    for (int i = 0; i < exponent; i++) {            
        int product = 0;
        for (int j = 0; j < x; j++) {
            for (int k = 0; k < result; k++) {
                product++;
            }
        }
        result = product;
    }
    return result;
}