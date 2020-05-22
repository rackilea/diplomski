public static void main(String args[])
{
    //setup all variables
    final double R   =(new Double(args[0])).doubleValue(); //=250.0;
    final double om1 =(new Double(args[1])).doubleValue(); //=  5.0;
    final   double om2 =(new Double(args[2])).doubleValue(); //= 15.0;
    final double th21=(new Double(args[3])).doubleValue(); //= 29.07965;
    final double th22=(new Double(args[4])).doubleValue(); //= 29.69008;
    final double D_obs = th21 - th22;

    BisectionSolver solver = new BisectionSolver();

    UnivariateFunction f = new UnivariateFunction()
    {
        public double value(double s) {
            return ((delta(R,om1,th21,s)-delta(R,om2,th22,s)) - (D_obs));
        }
    };

    System.out.printf("The speciment offset is %.3f mm.\n", solver.solve(1000, f, -3, 3));
}