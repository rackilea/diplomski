BigInteger solution;

if (y == 0) {
    solution = BigInteger.valueOf(1);
}
else if (y > 0) {        
    solution = BigInteger.valueOf(x);
    for (int i=0; i<y-1; i++) {
        solution = solution.multiply(BigInteger.valueOf(x));
    }
}
else {
    // Negative powers left as exercise to the reader
}