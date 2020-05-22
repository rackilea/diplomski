private static final Map<String,DoubleUnaryOperator> functions = new HashMap<>();
static {
    functions.put("sqrt", x -> Math.sqrt(x));
    functions.put("sin", x -> Math.sin(Math.toRadians(x)));
    functions.put("cos", x -> Math.cos(Math.toRadians(x)));
    functions.put("tan", x -> Math.tan(Math.toRadians(x)));
}