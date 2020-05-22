import com.joptimizer.functions.ConvexMultivariateRealFunction;
import com.joptimizer.functions.LinearMultivariateRealFunction;
import com.joptimizer.optimizers.JOptimizer;
import com.joptimizer.optimizers.OptimizationRequest;
import com.joptimizer.optimizers.PrimalDualMethod;

/**
 *
 * @author K.P.L.Kanchana
 */
public class Demo {

    public static void main(String[] args){
//        BasicConfigurator.configure(); // uncomment and see the console log4j:WARN

           // setting value for k as k1 variable
           double k1 = 100.2;

           // setting value for k' as k2 variable
           double k2 = 30.4;

        // Objective function (plane)
        LinearMultivariateRealFunction objectiveFunction = new LinearMultivariateRealFunction(new double[] {-k1, -k2}, 0); // Maximize kX + K'X

        //inequalities (polyhedral feasible set G.X<H )
        ConvexMultivariateRealFunction[] inequalities = new ConvexMultivariateRealFunction[4];
        // x > 0 ('<=' constraints not applicable in JOptimizer)
        inequalities[0] = new LinearMultivariateRealFunction(new double[] {-1, 0}, 0); // -x > o
        // y > 0 ('<=' constraints not applicable in JOptimizer)
        inequalities[1] = new LinearMultivariateRealFunction(new double[] {0, -1}, 0); // -y > o
        // x < 1 ('<=' constraints not applicable in JOptimizer)
        inequalities[2] = new LinearMultivariateRealFunction(new double[] {1, 0}, -1); // x-1 < o
        // y < 1 ('<=' constraints not applicable in JOptimizer)
        inequalities[3] = new LinearMultivariateRealFunction(new double[] {0, 1}, -1); // y-1 < o

        //optimization problem
        OptimizationRequest or = new OptimizationRequest();
        or.setF0(objectiveFunction);
        or.setFi(inequalities);

        or.setToleranceFeas(JOptimizer.DEFAULT_FEASIBILITY_TOLERANCE);
        or.setTolerance(JOptimizer.DEFAULT_TOLERANCE);

        //optimization
        PrimalDualMethod opt = new PrimalDualMethod();
        opt.setOptimizationRequest(or);
        try {
            int returnCode = opt.optimize();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return;
        }

        // get the solution
        double[] sol = opt.getOptimizationResponse().getSolution();

        // display the solution
        System.out.println("X = " + sol[0]);
        System.out.println("X = " + sol[1]);
    }

}