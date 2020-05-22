public class MathUnary implements UnaryFunction<Double, Double> {
    private final Method method;

    public MathUnary(String funName) {
        try {
            method = Math.class.getMethod(funName, double.class);
        } catch (NoSuchMethodException exc) {
            throw new IllegalArgumentException(exc);
        }
        if (method.getReturnType() != double.class)
            throw new IllegalArgumentException();
    }

    public Double call(Double arg) {
        try {
            return (Double) method.invoke(null, arg);
        } catch (IllegalAccessException exc) {
            throw new AssertionError(exc);
        } catch (InvocationTargetException exc) {
            throw new AssertionError(exc);
        }
    }
}