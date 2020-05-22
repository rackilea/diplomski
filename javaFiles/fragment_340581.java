class Test {
    public static void main(String[] args) { //static, non-instance method
        Inner inner = new Inner(); //error
    }

    class Inner { }
}