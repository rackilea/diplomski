public class MathHelper {
    public static double mvfBeale(int n, double[] x)
    {
        return Math.pow(1.5 - x[0] + x[0]*x[1], 2) +
        Math.pow(2.25 - x[0] + x[0] * x[1]*x[1], 2) +
        Math.pow(2.625 - x[0] + x[0] * Math.pow(x[1], 3), 2);
    }
}