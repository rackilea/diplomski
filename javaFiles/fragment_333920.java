public static ComplexNumber exp(ComplexNumber complex_number)
{
    double a = complex_number.real;
    double b = complex_number.imaginary;
    double r = Math.exp(a);
    a = r*Math.cos(b);
    b = r*Math.sin(b);
    return new ComplexNumber(a,b);
}