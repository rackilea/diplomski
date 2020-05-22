BigDecimal result = resultAsBigDecimal( (Number)tempResult[0] );

 public static BigDecimal resultAsBigDecimal( Number value ) {
     int i = value.intValue();
     if( 0 == i ) return BigDecimal.ZERO;
     if( 1 == i ) return BigDecimal.ONE;
     throw new RuntimException( "Unexpected value: " + value );
 }