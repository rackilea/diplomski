import java.util.*;

public class Foo {

    public static void main(String[] args)
    throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        //get user input (polynomial coefficients and interval values x1 and x2)
        ArrayList<Double> polynomialCoefficients = new ArrayList<Double>();
        int amountCoefficients = 0;
        while (scanner.hasNextDouble()) {
            polynomialCoefficients.add(scanner.nextDouble());
            amountCoefficients++;
        }

        Polynomial polynomial = new Polynomial(polynomialCoefficients);

        String in = scanner.next();

        while (scanner.hasNextDouble()) {
            double x = scanner.nextDouble();
            System.out.println("f(" + x + ") = " + polynomial.evaluate(x));
        }
    }

    static class Polynomial {

        ArrayList<Double> _coefficients;

        public Polynomial(ArrayList<Double> coefficients) {
            _coefficients = coefficients;
        }

        public double evaluate(double x) {
            double result = 0;

            // This algorithm is called Horner’s rule. See Knuth.
            for (int i = _coefficients.size() - 1; i>= 0; i--) {
                result *= x;
                result += _coefficients.get(i);
            }

            return result;
        }

    }

}