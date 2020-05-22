static int multiply(int... values) {
    int product = 1;

    for(int v : values) {
        product *= v;
    }

    return product;
}