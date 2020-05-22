KeyGenerator gen = KeyGenerator.getInstance("AES");
gen.init(128); /* 128-bit AES */
SecretKey secret = gen.generateKey();
byte[] binary = secret.getEncoded();
String text = String.format("%032X", new BigInteger(+1, binary));
System.out.println(text);