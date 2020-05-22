public static <T> T getStackElement(Stack<T> stack, int index) {
  if (index == 0) {
    return stack.peek();
  }

  T x = stack.pop();
  try {
    return getStackElement(stack, index - 1);
  } finally {
    stack.push(x);
  }
}