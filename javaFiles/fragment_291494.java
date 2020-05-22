public class Test {
     int i = init(1);

    Test() {
        System.out.println("Inside Constructor");
    }

    public int init(int i) {
        System.out.println("Inside Method");
        return i;
    }

    public static void main(String[] args) {
        System.out.println("start");
        Test i = new Test();
        System.out.println(i.i);
    }
}