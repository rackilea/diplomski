class TestClass {
    String a0;
    String a1;
    String a2;
    String a3;

    public TestClass(String a0, String a1, String a2, String a3) {
        this.a0 = a0;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }

    public TestClass(TestClass tc1, TestClass tc2) {
        this.a0 = tc1.a0;
        this.a1 = tc1.a1 + " + " + tc2.a1;
        this.a2 = tc1.a2 + " + " + tc2.a2;
        this.a3 = tc1.a3 + " + " + tc2.a3;
    }

    @Override
    public String toString() {
        return String.format("a0 = %s, a1 = %s, a3 = %s, a4 = %s", a0, a1, a2, a3);
    }
}