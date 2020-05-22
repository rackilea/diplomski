public class AddExpression extends ArithBinaryExpression {
    public AddExpression(ArithExpression leftExp, ArithExpression rightExp) {
        super(leftExp, rightExp);
    }

    public double result() {
        ArithExpression rightExp = getRightExpression();
        ArithExpression leftExp = getLeftExpression();
        return rightExp.result() + leftExp.result();
    }

    public String toString() {
        return "Expression: " + "(" + leftExpression.toString() + " + " + 
                rightExpression.toString() + ")";
    }

    public static void main(String args[]) {
       // create it here using new AddExpression ...
    }
}