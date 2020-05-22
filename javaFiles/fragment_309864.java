import java.util.*;

public class Test {

    public HashMap<String, double[][]> GradientDescent(double[][] ratingData_norm, double[][] ratingData_binary, double[][] theta, double[][] X, int iter, double alpha, double lambda)
    {
        HashMap<String, double[][]> result= new HashMap<String, double[][]>();

        double[][] theta_tran=new double[theta[0].length][theta.length]();
        double[][] theta_grad=new double[theta.length][theta[0].length]();
    }

}