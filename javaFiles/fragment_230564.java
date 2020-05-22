public class Threads {
    public static void main(String[] args) {
        Integer intObject = new Integer(0);
        for( int i=0;i<100;i++){

            new ThreadClass(i, intObject).start();     
        }
    }
}
class ThreadClass extends Thread {
    static boolean ok = false;
    int id;
    Integer intObject;
    public ThreadClass(int i, Integer intObject) {
        id = i;
        this.intObject = intObject;
    }

    public void run() {
        System.out.println("Thread start " + id);
        //Last.toDo(id);
        if (id == 5)
            waiting();
        else
            awaking(this);

        System.out.println("thread end " + id);
    }

    private static synchronized void awaking(ThreadClass t) {
        if(ok) {
            System.out.println("i'm " + t.id + " and i'm Awaking 5");
            ok = false;
            synchronized (t.intObject) {
                    t.intObject.notify();
                }
            System.out.println("I did the notify and i'm " + t.id);
        }
    }
    private void waiting(){
        System.out.println("Sleeping");
        ok = true;
        synchronized (intObject) {
            try {
                intObject.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Awake 5");
    }
}