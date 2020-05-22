public class MathTool {
    public static final int PLUS_OPERATION = 0;

    public static final int MINUS_OPERATION = 1;

    public static final int MULTIPLY_OPERATION = 2;

    public static final int DIVIDE_OPERATION = 3;

    public static double doMathOperation(double digit1, double digit2, int operation) {
        switch (operation) {
        case PLUS_OPERATION: return digit1 + digit2;
        case MINUS_OPERATION: return digit1 - digit2;
        case MULTIPLY_OPERATION: return digit1 * digit2;
        case DIVIDE_OPERATION: return digit1 / digit2;
        default: return 0;
        }
    }
}