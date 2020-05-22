public double nextDouble() {
    ...
    try {
        return Double.parseDouble(processFloatToken(next(floatPattern())));
    } catch (NumberFormatException nfe) {
        ...
    }
}