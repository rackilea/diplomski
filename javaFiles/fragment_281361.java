else if (input.equals("-")) {
    int n1 = stack.pop();
    int n2 = stack.pop();
    int result = n2 - n1;
    stack.push((int)result);
}