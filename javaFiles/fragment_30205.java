class Example {
    public static void main(String[] args) {
        Example e = new Example();
        e.hiThere();     // <========== Direct call to instance method
        go(e);
    }
    private static void go(Example e) {
        e.hiThere();     // <========== Direct call to instance method
    }
    private void hiThere() {
        System.out.println("Hi there");
    }
}