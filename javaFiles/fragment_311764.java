// signs = {"+" : lambda a, b : a + b, "-" : lambda a, b : a - b}
Map<String, IntBinaryOperator> signs = Map.of("+", (a, b) -> a + b, "-", (a, b) -> a - b);
int a = 5; // a = 5
int b = 3; // b = 3
// for i in signs.keys(): print(signs[i](a,b))
signs.values().forEach(v -> System.out.println(v.applyAsInt(a, b)));