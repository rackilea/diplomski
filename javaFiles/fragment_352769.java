/** May throw NullPointerException. */
public DecimalSpec setValue (Number value) {
    this.value  = new BigDecimal (value.toString ());
    return this;
}

/** May throw NullPointerException or IllegalArgumentException. */
public DecimalSpec setValue (Double value) {
    if (value.isNaN () || value.isInfinite ()) {
        throw new IllegalArgumentException ("Infinite or NaN values not allowed");
    }
    return this.setValue ((Number) value);
}