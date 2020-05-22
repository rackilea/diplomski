class C extends Thread {
    public void run() {
        while(true) {}
    }
}
C c = new C();
c.run();
System.out.println("Hello world");