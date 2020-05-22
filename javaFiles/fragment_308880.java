public class Blah implements Runnable {

    private String name;

    public Blah(String name) {
        this.name = name;
    }

    synchronized public void run() {
        try {
            synchronized (Blah.class) {
                System.out.println(name + ": Before notify " + new Date().toString());
                Blah.class.notifyAll();
                System.out.println(name + ": Before wait " + new Date().toString());
                Blah.class.wait(1000);
                System.out.println(name + ": After " + new Date().toString());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread th1 = new Thread(new Blah("Blah1"));
        Thread th2 = new Thread(new Blah("Blah2"));
        th1.start();
        th2.start();
    }
}