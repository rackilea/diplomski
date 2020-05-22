public int mulitply(int x, int y) {
    int product = 0;
    for (int i = 0; i < y; i++) {
       for (int j = 0; j < x; j++) {
          product++;
       }
    }
    return product;
}

public int power(int x, int exponent) {
    int result = 1;
    for (int i = 0; i < exponent; i++) {
        result = multiply(result, x);
    }
    return result;
}