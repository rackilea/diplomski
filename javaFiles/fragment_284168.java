Map<String, BinaryOperator<Integer>> operators = new TreeMap<>();
operators.put("add", (n1, n2) -> n1 + n2);
operators.put("minus", (n1, n2) -> n1 - n2);

if (operators.containsKey(opName)) {
    return operators.get(opName).apply(n1, n2);
}