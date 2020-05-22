double x = 1234567891234.0;
double y = 1234567891234.0;
System.out.println(x);
System.out.println(y);

BigDecimal bigZ = new BigDecimal(x).multiply(new BigDecimal(y));
double z = bigZ.doubleValue();
System.out.println(bigZ);
System.out.println(z);