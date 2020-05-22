double d = 0.66666666;
    NumberFormat format = new DecimalFormat("#.##");
    System.out.println(format.format(d)); // 0.67
    BigDecimal bigDecimal = new BigDecimal(d);
    bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
    System.out.println(bigDecimal); // 0.67