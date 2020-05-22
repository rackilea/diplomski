BigDecimal val = new BigDecimal(1.2);
    System.out.println(val.setScale(0, RoundingMode.HALF_UP));
    val = new BigDecimal(1.5);
    System.out.println(val.setScale(0, RoundingMode.HALF_UP));
    val = new BigDecimal(1.6);
    System.out.println(val.setScale(0, RoundingMode.HALF_UP));