for (int i = 0; i < 200; i++) {
    int    OPV = 230  + i %  15;        // 230 - 244 by 1
    double IKW = 1.3  + i %  17 * 0.1;  // 1.3 - 2.9 by 0.1
    double OKW = 0.01 + i %  49 * 0.01; // 0.01 - 0.49 by 0.01
    double OPI = 0.05 + i % 105 * 0.01; // 0.05 - 1.09 by 0.01
    System.out.printf("%d, %.1f, %.2f, %.2f%n", OPV, IKW, OKW, OPI);
}