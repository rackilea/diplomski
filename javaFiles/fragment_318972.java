public static void evaluateAndPrintResult(String s) {
    String[] str = s.split("\\s+");
    Queue<String> q = new LinkedList<>();
    q.addAll(Arrays.asList(str));
    Stack<String> ops = new Stack<>();
    Stack<Double> vals = new Stack<>();
    while (!q.isEmpty()) { // Read token, push if operator.
        String token = q.poll();
        switch (token) {
            case "(":
                break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "sqrt":
                ops.push(token);
                break;
            case ")":
                vals.push(evaluateOp(ops, vals));
                break;
            default:
                // Token not operator or paren: push double value.
                vals.push(Double.parseDouble(token));
                break;
        }
    }
    System.out.println(s + " = " + evaluateOp(ops, vals));
}

private static Double evaluateOp(Stack<String> ops, Stack<Double> vals) {
    // Replace the top exp with its result.
    double v = vals.pop();
    if (!ops.empty()) {
        String op = ops.pop();
        switch (op) {
            case "+":
                v = vals.pop() + v;
                break;
            case "-":
                v = vals.pop() - v;
                break;
            case "*":
                v = vals.pop() * v;
                break;
            case "/":
                v = vals.pop() / v;
                break;
            case "sqrt":
                v = Math.sqrt(v);
                break;
            default:
                break;
        }
    }
    return v;
}

public void test() {
    evaluateAndPrintResult("( ( 1 + 2 ) * 3 )");
}