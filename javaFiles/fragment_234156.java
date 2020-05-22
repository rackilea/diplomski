final Map<String, BiFunction<Integer, Integer, Integer>> opdict = new HashMap<>();
opdict.put("+", (x, y) -> x + y);
opdict.put("-", (x, y) -> x - y);
opdict.put("*", (x, y) -> x * y);
opdict.put("/", (x, y) -> x / y);

int sum = opdict.get("+").apply(5, 4);
System.out.println(sum);