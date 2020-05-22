package sandbox;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.BrentSolver;

public class BrentsMethodRootFinderExample {

    private void solveit () {
        BrentSolver solver = new BrentSolver();
        UnivariateFunction f = new UnivariateFunction() {

            @Override
            public double value(double x) {
                return 103*Math.pow(x, 5.0)-5*Math.pow(x, 4.0)-5*Math.pow(x, 3.0)-5*Math.pow(x, 2.0)-5*x - 105;
            }
        };

        double intervalStart = -10000;
        double intervalSize = 0.01;
        while (intervalStart < 10000) {
            intervalStart+= intervalSize;
            if(Math.signum(f.value(intervalStart)) != Math.signum(f.value(intervalStart+intervalSize))) {
                System.out.println("x = " + solver.solve(1000, f, intervalStart, intervalStart+intervalSize));
            }
        }
    }

    public static void main(String[] args) {
        new BrentsMethodRootFinderExample().solveit();
    }


}