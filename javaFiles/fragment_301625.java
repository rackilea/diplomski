public class P4 {

    public static void main(String args[])
    {
        Bean bean = Bean.getBean();
        new ThreadA(bean);
    bean.lock(true, true);
        new ThreadB(bean);
    }
}

class Bean
{   
    private static Bean instance = null;
    private Bean() {
    }

    int x;
    public static Bean getBean() {
        if (instance==null) {
            instance=new Bean();
        }
        return instance;
    }

    private boolean beanLocked;
    synchronized public boolean lock (boolean b, boolean l) {
    if (b) {
        beanLocked = l;
        notify();
    } else {
        while (beanLocked) {
        try {
            wait();
        } catch (InterruptedException ex) {
    }}}
    return beanLocked;
    }

    public int getX() {
        return x;
    }

    public void  setX(int x) {
        this.x = x;
    }

}

class ThreadA implements Runnable {
    Bean  b;
    public ThreadA(Bean b) {
        this.b=b;
    new Thread (this).start(); // run() uses b, set it before starting the thread
    }
    @Override
    public void run() {
        for (int i=1;i<=10;i++) {
            b.setX(i);
            System.out.println(Thread.currentThread().getName() + " "+b.getX());

    }
    b.lock(true, false);
}}

class ThreadB implements Runnable {
    Bean b;
    public ThreadB(Bean b) {
        this.b=b;
        new Thread(this).start();
    }
    @Override
    public void run() {
    b.lock(false, false);   // Dont care about 2nd argument
        for (int i=1;i<=10;i++) {
            b.setX(i);
            System.out.println(Thread.currentThread().getName() +" "+ b.getX());
}}}