BigDecimal pi = BigDecimal.ZERO;
for (int i = 0; i <= x; i++) {
    BigDecimal a = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(16).pow(i), 30, RoundingMode.HALF_UP);
    BigDecimal b1 = BigDecimal.valueOf(4).divide(BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(i)).add(BigDecimal.valueOf(1)), 30, RoundingMode.HALF_UP); 
    BigDecimal b2 = BigDecimal.valueOf(2).divide(BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(i)).add(BigDecimal.valueOf(4)), 30, RoundingMode.HALF_UP); 
    BigDecimal b3 = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(i)).add(BigDecimal.valueOf(5)), 30, RoundingMode.HALF_UP); 
    BigDecimal b4 = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(i)).add(BigDecimal.valueOf(6)), 30, RoundingMode.HALF_UP); 
    BigDecimal b = b1.subtract(b2).subtract(b3).subtract(b4);
    pi = pi.add(a.multiply(b));
}