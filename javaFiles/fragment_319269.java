int a = 1000;
    double b = 2.54643;
    System.out.printf("%.20f\n", a/b);

    BigDecimal a_2 = new BigDecimal(a);
    BigDecimal b_2 = new BigDecimal("2.54643");
    BigDecimal result = a_2.divide(b_2, 20, BigDecimal.ROUND_HALF_EVEN);
    System.out.println(result.toString());