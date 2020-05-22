public int add(int a, int b) {
    int result = a + b;
    if (result == 0) {
        throw new myError();
    }
    return result;
}

// Then use the add() method instead of +
try {
    int a = 1;
    int b = -1;
    int result = add(a, b);
    System.out.println(result);
} catch (myError e) {
    System.out.println("The result was zero!");
}