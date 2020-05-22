private double g(double z) {
    return 1 / (1 + Math.pow(2.71828, -z));
}

private double gD(double gZ) {
    return gZ * (1 - gZ);
}