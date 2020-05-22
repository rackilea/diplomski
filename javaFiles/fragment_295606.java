JSFunction factorial = new JSFunction(context,"factorial") {
    public Integer factorial(Integer x) {
        int factorial = 1;
        for (; x > 1; x--) {
            factorial *= x;
        }
        return factorial;
    }
};