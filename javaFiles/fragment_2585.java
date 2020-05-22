// input: "num1 + num2 * 3"
// result expression tree will be built by parser using:
Expression a = new Variable("num1");
Expression b = new Variable("num2");
Expression c = new Constant(3);
Expression d = new Multiply(b, c);
Expression e = new Plus(a, d);

Map<String, Double> variables = /*defined elsewhere*/;
double result = e.compute(variables);