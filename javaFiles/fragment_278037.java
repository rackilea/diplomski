public class Pattern {

    volatile int status = 1;

    public static void main(String[] args) {

        Pattern p = new Pattern();

        A1 a = new A1(p);
        B1 b = new B1(p);
        C1 c = new C1(p);

        a.start();
        b.start();
        c.start();
    }
}

class A1 extends Thread {
    Pattern p1;

    A1(Pattern p) {
        this.p1 = p;
    }

    @Override
    public void run() {

        try {
            synchronized (p1) {
                while (true) {
                    while (p1.status != 1) {
                        try {
                            p1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A ");
                    p1.status = 2;
                    p1.notifyAll();
                }
            }
        } catch (Exception e) {
            System.out.println("Exception 1 :" + e.getMessage());
        }

    }

}

class B1 extends Thread {

    Pattern p2;

    B1(Pattern p2) {
        this.p2 = p2;
    }

    @Override
    public void run() {

        try {
            synchronized (p2) {
                while (true) {
                    while (p2.status != 2) {
                        try {
                            p2.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("B ");
                    p2.status = 3;
                    p2.notifyAll();
                }
            }
        } catch (Exception e) {
            System.out.println("Exception 2 :" + e.getMessage());
        }

    }
}

class C1 extends Thread {

    Pattern p3;

    C1(Pattern p) {
        this.p3 = p;
    }

    @Override
    public void run() {

        try {
            synchronized (p3) {
                while (true) {
                    while (p3.status != 3) {
                        try {
                            p3.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("C ");
                    Thread.sleep(1000);
                    p3.status = 1;
                    p3.notifyAll();
                }
            }
        } catch (Exception e) {
            System.out.println("Exception 3 :" + e.getMessage());
        }

    }
}