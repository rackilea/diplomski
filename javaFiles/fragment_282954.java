public class MyTest {
    public static void main(String[] args) {
        new Test(); // Prints reference within the constructor
        new Test(); // The reference is different here
    }
}

class Test {
    public Test() {
        System.out.println(this.toString());
    }
}