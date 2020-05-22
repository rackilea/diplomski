interface Numeric {
    public void add(Numeric other);

    public void subtract(Numeric other);

    public void multiply(Numeric other);

    public Complex toComplex();

    public Fraction toFraction();
}