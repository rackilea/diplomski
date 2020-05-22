public static void main(String[] args) {
    MyProcess t = new MyProcess();
    t.start();

    try {
        t.join(10000L);
    } catch (InterruptedException ie) {
        System.out.println("interrupted");
    }

    System.out.println("Main thread resumes");
}