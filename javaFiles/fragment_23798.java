private static Double[][] calc_T(Matrix[] Ts) {
    Double[] t = Ts[0].x;
    for (int j = 1; j < 10; j++) {
        t = product(t, Ts[j].x);
    }
    return t;
}