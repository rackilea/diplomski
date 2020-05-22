BigInteger bi = new BigInteger("23").pow(23);
System.out.println("[BI] 23^23 = " + bi);
System.out.println("[BI] 23^23 mod 55 = " + bi.mod(new BigInteger("55")));

DecimalFormat df = new DecimalFormat("#");
System.out.println("[d] 23^23 = " + df.format(Math.pow(23, 23)));
System.out.println("[d] 23^23 mod 55 = " + df.format(Math.pow(23, 23) % 55));