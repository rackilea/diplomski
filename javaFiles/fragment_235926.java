static public BigDecimal[] split(BigDecimal sum, int prec, int count) {
    int s = sum.scaleByPowerOfTen(prec).intValue();
    Random r = new Random();
    BigDecimal[] result = new BigDecimal[count];
    int[] v = new int[count];

    for (int i = 0; i < count - 1; i++)
       v[i] = r.nextInt(s);
    v[count - 1] = s;

    Arrays.sort(v);
    result[0] = BigDecimal.valueOf(v[0]).scaleByPowerOfTen(-prec);
    for (int i = 1; i < count; i++)
       result[i] = BigDecimal.valueOf(v[i] - v[i - 1]).scaleByPowerOfTen(-prec);
    return result;
}