public static int applyOp(char op, int b, int a) {
    switch (op) {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '%':

            return (int)(((float) a / b) * 100);
        case '/':
            if (b == 0)
                throw new
                        UnsupportedOperationException("Cannot divide by zero");
            return a / b;
    }
    return 0;
}

}