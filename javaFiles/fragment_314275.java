import org.apache.commons.math3.special.Gamma;

/**
 * Binomial coefficient for real numbers - the number of ways of picking y
 * unordered outcomes from x possibilities
 *
 * @see http://mathworld.wolfram.com/BinomialCoefficient.html
 *
 * @param x
 * @param y
 * @return binomial coefficient to be generalized to noninteger arguments
 */
public double binomial(double x, double y) {
    double res = Gamma.gamma(x + 1) / (Gamma.gamma(y + 1) * Gamma.gamma(x - y + 1));
    if(Double.isNaN(res)){
        return 0.0;
    }
    return res;
}