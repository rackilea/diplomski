public static void main(String[] a) {
    Thread first = new Thread(new Runnable() {
        @Override
        public void run() {

        }
    });

    Thread second = new MyThread(first);
    first.start();
    second.start();

    //continue executing
}

public static class MyThread extends Thread {

    private Thread predecessor;

    public MyThread(Thread predecessor) {
        this.predecessor = predecessor;
    }

    public void run() {
        if (predecessor != null && predecessor.isAlive()) {
            try {
                predecessor.join();
            } catch (InterruptedException e) {}
        }
        //do your stuff
    }
}