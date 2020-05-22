class MultiThread implements Runnable {

    boolean gotInput = false;
    int i = 0;
    public void run() {
        for(;i <= 10 && !gotInput; i++) {
            System.out.println("Hello, User " + i;
            Thread.sleep(1000)
        }
    }

    public static void main(String args[]) {

        MultiThread mt = new MultiThread ();
        Thread t = new Thread(mt);
        t.start();

        Scanner s = new Scanner(System.in);
        while (!s.next().equals("pause"));

        test.gotInput = true;
    }
}