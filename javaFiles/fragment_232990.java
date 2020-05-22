static double N69cd8e58128(Object []i) {
    double p = Double.NaN;
    if (i[2] == null) {
        p = 1;
    } else if (((Double) i[2]).doubleValue() <= 6.43) {
        p = WekaClassifier.Nad3034129(i);
    } else if (((Double) i[2]).doubleValue() > 6.43) {
        p = WekaClassifier.N26ef16ed242(i);
    }
    return p;
}