public String generateFactors() {
    String ret = "";
    int[] factors = new int[number];

    for (int i = 0; i < number; i++) {
        //The remainder needs to be reversed
        if ((number % (i + 1)) == 0) {
            factors[i] = i+1;
        } else {
            factors[i] = 0;
        }
    }
    for (int i = 0; i < number; i++) {
        //only print them if they are a factor
        if(factors[i] != 0)
            ret += factors[i] + "\n";
    }
    return ret;
}