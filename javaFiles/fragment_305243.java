String priceStr = "2.9";
    BigDecimal price = new BigDecimal(priceStr);
    System.out.println(price);
    // output 2.9

    priceStr = "2.90";
    price = new BigDecimal(priceStr);
    System.out.println(price);
    // output 2.90

    Double priceDouble = 2.90;
    price = new BigDecimal(priceDouble);
    System.out.println(price);
    // output 2.89999999999999... need to do some rounding

    priceDouble = 2.90;
    price = new BigDecimal(priceDouble).setScale(2, RoundingMode.CEILING);
    System.out.println(price);
    // output 2.90