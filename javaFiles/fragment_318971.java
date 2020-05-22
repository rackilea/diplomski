public static void evaluateAndPrintResult(String s) {
    String[] str = s.split("\\s+");
    Queue<String> q = new LinkedList<>();
    q.addAll(Arrays.asList(str));
    Stack<String> ops = new Stack<>();
    Stack<Double> vals = new Stack<>();
    while (!q.isEmpty()) { // Read token, push if operator.
        String token = q.poll();
        if (token.equals("(")) {
        } else if (token.equals("+")) {
            ops.push(token);
        } else if (token.equals("-")) {
            ops.push(token);
        } else if (token.equals("*")) {
            ops.push(token);
        } else if (token.equals("/")) {
            ops.push(token);
        } else if (token.equals("sqrt")) {
            ops.push(token);
        } else if (token.equals(")")) {
            vals.push(evaluateOp(ops, vals));
        } else {
            // Token not operator or paren: push double value.
            vals.push(Double.parseDouble(token));
        }
    }
    System.out.println(evaluateOp(ops, vals));
}

private static Double evaluateOp(Stack<String> ops, Stack<Double> vals) {
    // Replace the top exp with its result.
    double v = vals.pop();
    String op = ops.pop();
    if (op.equals("+")) {
        v = vals.pop() + v;
    } else if (op.equals("-")) {
        v = vals.pop() - v;
    } else if (op.equals("*")) {
        v = vals.pop() * v;
    } else if (op.equals("/")) {
        v = vals.pop() / v;
    } else if (op.equals("sqrt")) {
        v = Math.sqrt(v);
    }
    return v;
}

public void test() {
    evaluateAndPrintResult("( 1 + 2 ) * 3");
}