for (BigInteger bi = BigInteger.valueOf(5);
            bi.compareTo(BigInteger.ZERO) > 0;
            bi = bi.subtract(BigInteger.ONE)) {

        System.out.println(bi);
    }
    // prints "5", "4", "3", "2", "1"