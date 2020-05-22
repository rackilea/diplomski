public static void main(String[] args) {
    TestThread r = new TestThread();
    r.setParameter("myParameterHere");
    Thread t = new Thread(r);
    t.setName("asdas");
    t.start();
    System.out.println("Hey the thread has ended");
}