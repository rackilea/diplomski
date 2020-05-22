BinaryOperator<Integer> add = (a, b) -> a + b;//lambda a, b : a + b
BinaryOperator<Integer> sub = (a, b) -> a - b;//lambda a, b : a - b

// Then create a new Map which take the sign and the corresponding BinaryOperator
// equivalent to signs = {"+" : lambda a, b : a + b, "-" : lambda a, b : a - b}
Map<String, BinaryOperator<Integer>> signs = Map.of("+", add, "-", sub);

int a = 5; // a = 5
int b = 3; // b = 3

// Loop over the sings map and apply the operation
signs.values().forEach(v -> System.out.println(v.apply(a, b)));