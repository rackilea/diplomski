public interface Complex<T> {

    T getReal();
    T getImaginary();

    Complex<T> opposite(Complex<T> z);
    double abs();
    Complex<T> conjugate();
    Complex<T> inverse();

    Complex<T> add(Complex<T> z);
    Complex<T> subtract(Complex<T> z);
    Complex<T> product(Complex<T> z);
    Complex<T> div(Complex<T> z);

}

public class DoubleComplex implements Complex<Double> {

    private final double real;
    private final double imaginary;

    ...

    @Override
    public Complex<Double> add(Complex<Double> z) {
        return new DoubleComplex(this.real + z.getReal(), this.imaginary + z.getImaginary());
    }

    ...
}

public class RationalComplex implements Complex<Rational> {

    private final Rational real;
    private final Rational imaginary;

    ...

    @Override
    public Complex<Rational> add(Complex<Rational> z) {
        return new RationalComplex(this.real.add(z.getReal()), this.imaginary.add(z.getImaginary()));
    }

    ...
}