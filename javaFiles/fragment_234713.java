public static boolean isBalanced(String expr) {
  Stack<String> stack = new Stack<>();

  for (int i = 0; i < expr.length(); i++) {
    if (expr.charAt(i) == ('(')){
      stack.push("(");
    }
    else if (expr.charAt(i) == (')')) {
      if (stack.isEmpty()) {
        return false;
      }
      stack.pop();
    }
  }

  return stack.isEmpty();
}