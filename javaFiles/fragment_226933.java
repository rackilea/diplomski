/** 
 * For text comparsion or log propouse
 * @return human readable text without decimal zeros 
 */
public static String getPlainText( BigDecimal value ) {
    if ( value == null )
        return null;

    // Strip only values with decimal digits
    BigDecimal striped = ( value.scale() > 0 ) ? value.stripTrailingZeros() : value;
    return striped.toPlainString();
}

/** 
 * For comparison by equals method like test assertEquals
 * @return new instance without decimal zeros 
 */
public static BigDecimal stripDecimalZeros( BigDecimal value ) {
    if ( value == null )
        return null;

    // Strip only values with decimal digits
    BigDecimal striped = ( value.scale() > 0 ) ? value.stripTrailingZeros() : value;
    // Unscale only values with ten exponent
    return ( striped.scale() < 0 ) ? striped.setScale( 0 ) : striped;
}