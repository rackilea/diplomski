BigDecimal a = new BigDecimal("10.12345");
BigDecimal b = new BigDecimal("10.12556");

a = a.setScale(2, BigDecimal.ROUND_HALF_EVEN);
b = b.setScale(2, BigDecimal.ROUND_HALF_EVEN);

System.out.println(a);
System.out.println(b);