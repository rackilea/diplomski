class Complex implements Numeric {

    private final int re, im;

    public Complex(int re, int im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public Numeric add(Numeric other) {
        Complex complex = other.toComplex();
        return new Complex(this.re + complex.re, this.im + complex.im);
    }

    @Override
    public Numeric subtract(Numeric other) {
        Complex complex = other.toComplex();
        return new Complex(this.re - complex.re, this.im - complex.im);
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