public static void main(String[] args) {
  System.out.println(generateSequenceDoubleStream(0.0, 2.0, 0.2));
  //[0.0, 0.2, 0.4, 0.6000000000000001, 0.8, 1.0, 1.2, 1.4, 1.5999999999999999, 1.7999999999999998, 1.9999999999999998]

  System.out.println(generateSequenceIntStream(0, 20, 2, 0.1));
  //[0.0, 0.2, 0.4, 0.6000000000000001, 0.8, 1.0, 1.2000000000000002, 1.4000000000000001, 1.6, 1.8, 2.0]

  System.out.println(generateSequenceBigDecimal(new BigDecimal("0"), new BigDecimal("2"), new BigDecimal("0.2")));
  //[0.0, 0.2, 0.4, 0.6, 0.8, 1.0, 1.2, 1.4, 1.6, 1.8, 2.0]
}