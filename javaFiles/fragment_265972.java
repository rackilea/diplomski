public String generateFactors() {
    String ret = "";
    int[] factors = new int[number];

    for (int i = 0; i < number; i++) {
        if ((i + 1 % number) == 0) {
            factors[i] = i;
            ret += "Factor= " + i + "\n";
        } else {
            factors[i] = 0;
        }
    }
    for (int i = 0; i < number; i++) {
        ret += factors[i] + "\n";
    }
    return ret;
}