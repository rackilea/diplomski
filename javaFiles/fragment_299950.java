public static void main(String[] args) {

    DerivativeApprox cosDerApprox = new DerivativeApprox(0.0001) {
        @Override
        double func(double x) {
            return Math.cos(x);
        }
    };

    DerivativeApprox sinDerApprox = new DerivativeApprox(0.0001) {
        @Override
        double func(double x) {
            return Math.sin(x);
        }
    };

    System.out.println("Cos'(pi) = " + cosDerApprox.eval(Math.PI));
    System.out.println("Cos'(pi/2) = " + cosDerApprox.eval(Math.PI / 2));

    System.out.println("Sin'(pi) = " + sinDerApprox.eval(Math.PI));
    System.out.println("Sin'(pi/2) = " + sinDerApprox.eval(Math.PI / 2));

}