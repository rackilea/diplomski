public abstract class DerivativeApprox {

    abstract double func(double x);

    double eps = 0.0;

    DerivativeApprox(double eps){
        this.eps = eps;
    }

    public double eval(double xPoint){
        return (func(xPoint + eps) - func(xPoint - eps)) / (2 * eps);
    }
}