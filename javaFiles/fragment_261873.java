public class OverloadingDemo {

    public static void main(String args[]) {
        OverloadingDemo obj = new OverloadingDemo();
        obj.sayHello(10);
    }

    public void sayHello(long x) {
        System.out.println("Hello long  " + x);
    }

    public void sayHello(double x) {
        System.out.println("Hello double  " + x);
    }

}