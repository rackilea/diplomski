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
        } else if (token.equals(")")) { // Pop, evaluate, and push result if token is ")".
            // Replace the top exp with it' result.
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
            vals.push(v);
        } else {
            // Token not operator or paren: push double value.
            vals.push(Double.parseDouble(token));
        }
    }
    System.out.println(vals.pop());
}

public void test() {
    evaluateAndPrintResult("( ( 1 + 2 ) * 3 )");
}