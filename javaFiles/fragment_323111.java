public static double fracHorner(int[] coef, int base, int it) {
    if (it == 0) {
        return ((double)coef[it])/base;
    }
    return (fracHorner(coef, base, it-1) + coef[it])/base;
}