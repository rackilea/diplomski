private void printStack(Stack<Integer> stack) {
    if (stack.isEmpty()) {
        return;
    } else {
        int i = stack.pop();
        printStack(stack);
        System.out.println(i);
    }
}