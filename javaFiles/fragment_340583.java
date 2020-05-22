class Test {
    public static void main(String[] args) { //static, non-instance method
        Test test = new Test();
        Inner inner = test.new Inner(); //error
    }

    class Inner { }
}