// toString
    long l = 0x0ffffffffffffeffL;
    {
        final long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) toStringBi(l);
        System.out.println("BigInteger time = " + 
            (System.currentTimeMillis() - start) + " ms.");
    }
    {
        final long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) Long.toString(l, 36);
        System.out.println("Long.toString time = " + 
           (System.currentTimeMillis() - start) + "ms.");
    }
    // Parsing
    final String b36 = toStringBi(l);
    final String long36 = Long.toString(l, 36);
    {
        final long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            final BigInteger parsedBi = new BigInteger(b36, 36);
            l = parsedBi.longValue();
            if (parsedBi.testBit(64)) l = l | (1L << 63);
        }
        System.out.println("BigInteger.parse time = " 
            + (System.currentTimeMillis() - start) + " ms.");
    }
    {
        final long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) Long.parseLong(long36, 36);
        System.out.println("Long.parseLong time = " 
            + (System.currentTimeMillis() - start) + "ms.");
    }