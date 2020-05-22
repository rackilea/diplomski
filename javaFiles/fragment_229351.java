for(double i = 1; i > .001; i /= 10) {
    while(!(Math.pow(k, value) > n )) {
        value += i;
    }
    value -= i;
}