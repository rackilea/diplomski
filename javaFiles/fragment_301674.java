class A1 {
    private int data;

    public A1(int input) {
        data = computeData(input);
    }

     protected int computeData(int i) {
        return i;
    }

    public String toString() { return "" + data;}
}

class B1 extends A1 {
    public B1(int input) {
         super(input);
    }

     protected int computeData(int i) {
        return 2*i;
    }   
}

public class Example {
    public static void main(String[] args) {
        System.out.println(new A1(1) + " " + new B1(1));
    }
}