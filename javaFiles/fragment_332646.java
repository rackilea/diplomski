public static void main(String[] args) {
        InputOutput io = new InputOutput();
        Thread t1 = new Thread(new input(io));
        t1.start();
        Thread t2 = new Thread(new output(io));
        t2.start();
    }

    private static class input implements Runnable {
        private int i = 1;
        private InputOutput io;

        public input(InputOutput io) {
            this.io = io;
        }

        public void run() {
            for (i = 1; i <= 10; i++)
                io.input();
        }
    }

    private static class output implements Runnable {
        private int i = 1;
        private InputOutput io;

        public output(InputOutput io) {
            this.io = io;
        }

        public void run() {
            for (i = 1; i <= 10; i++)
                io.output();
        }
    }
}

class InputOutput {
    private int i = 0;
    private boolean ToF = false;

    synchronized void output() {
        try {
            while (!ToF) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Output: " + i);
        ToF = false;
        notify();
    }

    synchronized void input() {
        try {
            while (ToF) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++;
        ToF = true;
        notify();
    }

}