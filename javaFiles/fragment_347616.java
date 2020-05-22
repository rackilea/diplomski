BigDecimal v1 = new BigDecimal("15.25");
BigDecimal v2 = new BigDecimal("5.25");
BigDecimal v3 = new BigDecimal("1.15");

BigDecimal v123 = v1.divide(v2, MathContext.DECIMAL64).multiply(v3);

System.out.println(v123);
System.out.println(v123.setScale(2, RoundingMode.HALF_UP));