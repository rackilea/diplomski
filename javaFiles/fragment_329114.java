public static void main(String[] args) {
    double[][][] da= { {{ 0.1 }, { }}, {{ 0.2, 0.3 }, { 0.4 }} };
    BigDecimal[][][] bd=convert(da,
      v -> Arrays.stream((double[])v).mapToObj(BigDecimal::new).toArray(BigDecimal[]::new),
      BigDecimal[][][].class);
    System.out.println(Arrays.deepToString(bd));
}