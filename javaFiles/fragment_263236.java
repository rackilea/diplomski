BigInteger bi = new BigInteger("20000000");
System.out.println(bi);

BitSet bs = convertTo(bi);
System.out.println(bs);

BigInteger bi2 = convertFrom(bs);
System.out.println(bi2);