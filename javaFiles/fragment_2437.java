public class Division {

    private BigDecimal dividend;
    private BigDecimal divisor;
    private BigDecimal result;

    @NotNull
    public BigDecimal getDividend() {
        return dividend;
    }

    public void setDividend(BigDecimal dividend) {
        this.dividend = dividend;
    }

    public BigDecimal getDivisor() {
        return divisor;
    }

    @NotZero
    @NotNull
    public void setDivisor(BigDecimal divisor) {
        this.divisor = divisor;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

}