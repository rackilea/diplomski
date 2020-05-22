long l = 0xffffffffffffffffL; // any long, e.g. -1

    // to string
    BigInteger bi = new BigInteger(Long.toString(l & ~(1L << 63)));
    if (l < 0) bi = bi.setBit(64);
    final String b36 = bi.toString(36);
    System.out.println("original long:" + l);
    System.out.println("result 36: " + b36);

    // parse
    final BigInteger parsedBi = new BigInteger(b36, 36);

    l = parsedBi.longValue();
    if (parsedBi.testBit(64)) l = l | (1L << 63);
    System.out.println("parsed long = " + l);