class Fraction {

    private final BigDecimal numerator;
    private final BigDecimal denominator;

    public Fraction(BigDecimal numerator, BigDecimal denumerator) {
        this.numerator = numerator;
        this.denominator = denumerator;
    }

    public static final Fraction ZERO = new Fraction(BigDecimal.ZERO, 
                            BigDecimal.ONE);
    public static final Fraction ONE = new Fraction(BigDecimal.ONE, 
                            BigDecimal.ONE);

    public static Fraction of(BigDecimal numerator) {
        return new Fraction(numerator, BigDecimal.ONE);
    }

    public static Fraction of(BigDecimal numerator, BigDecimal denominator) {
        return new Fraction(numerator, denominator);
    }

    public Fraction add(Fraction other) {
        return Fraction.of(other.denominator.multiply(this.numerator)
                                .add(other.numerator.multiply(this.denominator)),
                           this.denominator.multiply(other.denominator));
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(this.numerator.multiply(other.numerator), 
                            this.denominator.multiply(other.denominator));
    }

    public Fraction divide(Fraction other) {
        return new Fraction(this.numerator.multiply(other.denominator), 
                            this.denominator.multiply(other.numerator));
    }

    public BigDecimal value() {
        try {
            return this.numerator.divide(this.denominator);
        } catch (ArithmeticException ae) {
            return this.numerator.divide(this.denominator, 6, 
                        RoundingMode.HALF_UP);
        }
    }

    @Override
    public String toString() {
        return String.format("%s/%s", this.numerator, this.denominator);
    }
}