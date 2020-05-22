public class Worker extends Thread {
    int[] val;
    Worker next;
    boolean ready;
    boolean go;

    Worker(int[] val) {
        this.val = val;
    }

    public void setNext(Worker next) {
        this.next = next;
    }

    @Override
    public void run() {
        synchronized (Worker.class) {
            ready = true;
            Worker.class.notifyAll();
            for (int i = 0; i < val.length; i++) {
                try {
                    while (!go) {
                        Worker.class.wait();
                    }
                    System.out.println(val[i]);
                    go = false;
                    next.go = true;
                    Worker.class.notifyAll();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Worker worker1 = new Worker(new int[] { 1, 4, 7 });
        Worker worker2 = new Worker(new int[] { 2, 5, 8 });
        Worker worker3 = new Worker(new int[] { 3, 6, 9 });

        worker1.setNext(worker2);
        worker2.setNext(worker3);
        worker3.setNext(worker1);

        worker1.start();
        worker2.start();
        worker3.start();

        synchronized (Worker.class) {
            while(!worker1.ready || !worker2.ready ||!worker3.ready ) {
                Worker.class.wait();
            }
            worker1.go = true;
            Worker.class.notifyAll();
        }
    }
}