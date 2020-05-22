MathUnary[] ops = {
    new MathUnary("sin"), new MathUnary("cos"), new MathUnary("tan")
};

for (UnaryFunction<Double, Double> op1 : ops) {
    for (UnaryFunction<Double, Double> op2 : ops) {
        op1.call(op2.call(arg));
    }
}