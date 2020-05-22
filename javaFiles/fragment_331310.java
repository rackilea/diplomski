Operation operation = new Operation() {
    @Override
    public int op(int a, int b) {
        return a * b;
    }
};

// Usage
System.out.println(operation.op(5, 2)); // 10