// Somewhere else in our project, in the `MathUtil` class
public static int multiply(int a, int b) {
    return a * b;
}

// Usage
Operation operation = MathUtil::multiply;
System.out.println(operation.op(5, 2)); // 10