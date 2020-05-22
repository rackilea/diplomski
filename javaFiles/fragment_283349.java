System.out.println("With no rounding");
float n = 22.65f;
System.out.println("n= "+new BigDecimal(n));
float expected = 0.65f;
System.out.println("expected= "+new BigDecimal(expected));

System.out.println("n % 1= "+new BigDecimal(n % 1));
System.out.println("n - Math.floor(n) = "+new BigDecimal(n - Math.floor(n)));
System.out.println("n - (int)n= "+new BigDecimal(n - (int)n));

System.out.println("With rounding");
System.out.printf("n %% 1= %.2f%n", n % 1);
System.out.printf("n - Math.floor(n) = %.2f%n", n - Math.floor(n));
System.out.printf("n - (int)n= %.2f%n", n - (int)n);