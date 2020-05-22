interface ForwardTest {
    Test get();
}

class Main {
    public static void main (String[] args) throws java.lang.Exception {
        final Test[] test = new Test[20];
        ForwardTest t = new ForwardTest() {public Test get() {return test[10];} };
        test[10] = new Test(7);
        System.out.println(t.get().whatever);
    }
}

class Test {
    public Test(int i){this.whatever = i;}
    Integer whatever;
}