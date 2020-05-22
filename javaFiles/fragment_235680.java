interface Expression<T> {
    public T evaluate();
}

class BinaryDoubleExpression implements Expression<Double> {
    DoubleExpression left, right;
    DoubleOperator operator;

    BinaryDoubleExpression(double left, double right, BinaryDoubleOperator operator) {
        this.left = left;
        this.right = right;
    }

    Double evaluate() {
        return operator.operate(left.evaluate(), right.evaluate());
    }
}

enum BinaryDoubleOperator {
    ...
    Double operate();
}