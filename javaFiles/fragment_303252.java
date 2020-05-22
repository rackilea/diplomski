public class Arbit {
    public static void main(String[] args) throws Exception{
        B b1 = new B("1");
        B b2 = new B("2");
        B b3 = new B("3");
        b1.start();
        b2.start();
        b3.start();
        b1.join();
        b2.join();
        b3.join();
    }
}

class B extends Thread{
    B(String s){
        setName(s);
    }
    @Override
    public void run() {

        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
        }
        System.out.println(A.s);
    }
}

class A{
    static String s = Thread.currentThread().getName();
}