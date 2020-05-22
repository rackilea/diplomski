public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode) {
    if (roundingMode < ROUND_UP || roundingMode > ROUND_UNNECESSARY)
        throw new IllegalArgumentException("Invalid rounding mode");
    if (this.intCompact != INFLATED) {
        if ((divisor.intCompact != INFLATED)) {
            return divide(this.intCompact, this.scale, divisor.intCompact, divisor.scale, scale, roundingMode);
        } else {
            return divide(this.intCompact, this.scale, divisor.intVal, divisor.scale, scale, roundingMode);
        }
    } else {
        if ((divisor.intCompact != INFLATED)) {
            return divide(this.intVal, this.scale, divisor.intCompact, divisor.scale, scale, roundingMode);
        } else {
            return divide(this.intVal, this.scale, divisor.intVal, divisor.scale, scale, roundingMode);
        }
    }
}