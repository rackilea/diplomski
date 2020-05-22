public static void main(String[] args) throws InterruptedException {

    A a1  = new A();
    Thread a = new Thread(a1);
    a.start();
    a.join();
    System.out.println("hi");
}