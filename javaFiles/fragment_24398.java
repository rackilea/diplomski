long var1 = -3676984925397286887L;

IoBuffer ioBuffer1 = IoBuffer.allocate(8);
ioBuffer1.putLong(var1);

BigInteger bi = new BigInteger(1, ioBuffer1.array());

System.out.println(bi);             // 14769759148312264729
System.out.println(bi.longValue()); // -3676984925397286887