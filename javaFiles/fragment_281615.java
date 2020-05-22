// Create a large, ugly number.
    BigInteger bi = BigInteger.valueOf(1001).pow(345);

    // Convert to scientific notation using invariant Locale.ROOT
    NumberFormat formatter = new DecimalFormat("0.######E0", DecimalFormatSymbols.getInstance(Locale.ROOT));
    String str = formatter.format(bi);

    System.out.println(bi);
    System.out.println();
    System.out.println(str);

    // No need for a formatter here.
    BigDecimal bd = new BigDecimal(str);
    BigInteger output = bd.toBigInteger();

    System.out.println();
    System.out.println(output);