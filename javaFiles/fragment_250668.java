double first = 1d;
double second = 0.00000000000000001d;

System.out.println("Db --> " + (first - second));

BigDecimal firstBd = new BigDecimal(first);
BigDecimal secondBd = new BigDecimal(second);
BigDecimal resultBd = firstBd.subtract(secondBd);

System.out.println("32 --> " + resultBd.round(MathContext.DECIMAL32));
System.out.println("64 --> " + resultBd.round(MathContext.DECIMAL64));
System.out.println("128--> " + resultBd.round(MathContext.DECIMAL128));
System.out.println("Unl--> " + resultBd);