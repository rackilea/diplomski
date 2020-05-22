final Map<String, IntBinaryOperator> opdict = new HashMap<>();
opdict.put("+", (x, y) -> x + y);
opdict.put("-", (x, y) -> x - y);
opdict.put("*", (x, y) -> x * y);
opdict.put("/", (x, y) -> x / y);

int sum = opdict.get("+").applyAsInt(5, 4);
System.out.println(sum);