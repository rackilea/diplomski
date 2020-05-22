class Complex implements Numeric {

    private int Re, Im;

    @Override
    public void add(Numeric other) {
        Complex complex = other.toComplex();
        this.Re += complex.Re;
        this.Im += complex.Im;
    }

    @Override
    public void subtract(Numeric other) {
        Complex complex = other.toComplex();
        this.Re -= complex.Re;
        this.Im -= complex.Im;
    }

    @Override
    public Complex toComplex() {
        return this;
    }

    @Override
    public Fraction toFraction() {
        //convert to fraction
        return null;
    }
    //rest of the implementation
}