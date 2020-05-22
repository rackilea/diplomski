interface Numeric {
    public Numeric add(Numeric other);

    public Numeric subtract(Numeric other);

    public Numeric multiply(Numeric other);

    public Complex toComplex();

    public Fraction toFraction();
}