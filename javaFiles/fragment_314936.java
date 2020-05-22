Stack<Integer> mainStack = new Stack<>(); // elements pop in correct order
// the fake queue so to speak

public void push(int x) {
    Stack<Integer> stack = new Stack<>(); // temporary stack
    // reverse main stack
    while (!mainStack.empty())
        stack.push(mainStack.pop());
    // add x first (at the bottom) of the now empty main stack
    mainStack.push(x);
    // add the rest of the elements to main stack (preserving original order,
    // by reversing the elements again)
    while (!stack.empty())
        mainStack.push(stack.pop());
}