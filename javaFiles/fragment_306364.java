String str = "987654987855";
String max = String.valueOf(Integer.MAX_VALUE);
String min = String.valueOf(Integer.MIN_VALUE);
BigInteger b1 =    new BigInteger(str);
BigInteger b_max = new BigInteger(max);
BigInteger b_min = new BigInteger(min);
boolean isOutOfRange = b1.compareTo(b_max) > 0 || b1.compareTo(b_min) < 0;
System.out.println(isOutOfRange); // Output true