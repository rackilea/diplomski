public static int recursiveAlgorithm(int r, int p) {

    if (r == 0) {
        return p + 1;
    }

    if (p == 0){
        return recursiveAlgorithm(r - 1, 1);
    }

    else {
        return recursiveAlgorithm(r - 1, recursiveAlgorithm(r, p - 1));
    }

}