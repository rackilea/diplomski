public static void Fnc3S(int a, int b) {
    Stack<Integer> stack = new Stack<>(); // single stack for both input variables
    Stack<Integer> output = new Stack<>(); // single stack for output variable

    stack.push(a); // push original input
    stack.push(b);

    do {
        int bVal = stack.pop();
        int aVal = stack.pop();

        if (aVal <= bVal) {
            int m = (aVal + bVal) / 2;
            output.push(m); // push output

            stack.push(m + 1); // start with 2nd call to original function, remember - reverse order
            stack.push(bVal);

            stack.push(aVal); // push variables used for 1st call to original function
            stack.push(m - 1);
        } else {
            if (!output.empty()) { // original function just returns here to caller, so we should print any previously calculated outcome
                System.out.println(output.pop());
            }
        }
    } while (!stack.empty());
}