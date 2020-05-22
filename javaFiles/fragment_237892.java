double d = 0.66666666;
    DecimalFormat format = new DecimalFormat("#.##");
    format.setRoundingMode(RoundingMode.DOWN);
    System.out.println(format.format(d)); // 0.66
    BigDecimal bigDecimal = new BigDecimal(d);
    bigDecimal = bigDecimal.setScale(2, RoundingMode.DOWN);
    System.out.println(bigDecimal); //0.66