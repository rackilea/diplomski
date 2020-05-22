double val = 3.9 - (3.9 % 0.1);
    System.out.println(val); // 3.8000000000000003

    BigDecimal x = new BigDecimal( "3.9" );
    BigDecimal bdVal = x.subtract( x.remainder( new BigDecimal( "0.1" ) ) );
    System.out.println(bdVal); // 3.9