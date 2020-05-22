public class BBBThread implements Runnable {

    int i=0;
    public void add() {
        synchronized(this){     
            i++;
            System.out.println(i);
        }
    }

    @ooverride
    public void run() {
        for (int i=0; i < 10000; i++) {
            add();
        }
    }

    public static void main(String[] args) {
        BBBThread bbbObj =new BBBThread();
        Thread t1=new Thread(bbbObj,"A");
        Thread t2=new Thread(bbbObj, "B");
        Thread t3=new Thread(bbbObj, "C");
        Thread t4=new Thread(bbbObj, "D");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}