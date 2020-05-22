public class Subtract extends ArithmeticExpression {
    double  result;

    public Subtract(double x, double y) {
        this.binary1 = x;
        this.binary2 = y;
    }

    @Override
    public void evaluate() {
        result = binary1 - binary2;
    }

    @Override
    public void display() {
        System.out.println("Expression: " + binary1 + 
                " - " + binary2 + " = " + result);
    }

}