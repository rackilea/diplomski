float a = 8250325.12f;
float b = 4321456.31f;
float c = a + b;
System.out.println(NumberFormat.getCurrencyInstance().format(c));
// prints $12,571,782.00 (wrong)

BigDecimal a1 = new BigDecimal("8250325.12");
BigDecimal b1 = new BigDecimal("4321456.31");
BigDecimal c1 = a1.add(b1);
System.out.println(NumberFormat.getCurrencyInstance().format(c1));
// prints $12,571,781.43 (right)