BigDecimal bd = new BigDecimal("0.0000");

    if (bd.doubleValue() % 1 == 0.0 ){
    System.out.println(bd.setScale(0));

// You can also convert to Integer: 
// Integer response = bd.setScale(0).toBigInteger().intValue();

    } else {
    System.out.println(bd.setScale(4));
    }