/**
 * Created for http://stackoverflow.com/q/22929746/1266906
 */
public class MinusFunction {

    public static BivariateFunction invert(final BivariateFunction function) {
        return new BivariateFunction() {
            @Override
            public double value(double x, double y) {
                return - function.value(x,y);
            }
        };
    }

    public static MultivariateFunction invert(final MultivariateFunction function) {
        return new MultivariateFunction() {
            @Override
            public double value(double[] point) {
                return -function.value(point);
            }
        };
    }

    public static MultivariateMatrixFunction invert(final MultivariateMatrixFunction function) {
        return new MultivariateMatrixFunction() {
            @Override
            public double[][] value(double[] point) {
                final double[][] value = function.value(point);
                for (int i = 0; i < value.length; i++) {
                    for (int j = 0; j < value[i].length; j++) {
                        value[i][j] = -value[i][j];
                    }
                }
                return value;
            }
        };
    }
}