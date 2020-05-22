Map<String,Double> variables = new HashMap<>();
Expression exp = parse("x+(sqrt(x))", variables);
for (double x = 100; x <= +120; x++) {
    variables.put("x", x);
    System.out.println(x + " => " + exp.eval());
}