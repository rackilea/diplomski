final double result = si.integrate(50, new UnivariateFunction() {
        @Override public double value(double x) {
            return 2*x;
        }
    }, 0, 10);
System.out.println(result + " should be 100");