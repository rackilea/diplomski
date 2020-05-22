BigInteger bi = new BigInteger("31415926535");
bi = bi.multiply(new BigInteger("271828"));
System.out.println(bi);
BitSet bs = BitSet.valueOf(bi.toByteArray());
System.out.println(bs);
BigInteger bi2 = new BigInteger(bs.toByteArray());
System.out.println(bi2);