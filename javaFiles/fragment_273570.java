public Fraction multiply(Fraction other) {
    int counter = other.getCounter() * this.counter;
    int denim = other.getDenominator() * this.denom;

    return new Fraction(counter, denom);
}