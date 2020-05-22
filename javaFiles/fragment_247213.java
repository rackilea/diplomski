public class Test {

    public static void main(String[] args) {
        Action action = new Action();
        Thread t1 = new Thread(new Runner(action), "1");
        Thread t2 = new Thread(new Runner(action), "2");
        Thread t3 = new Thread(new Runner(action), "3");
        Thread t4 = new Thread(new Runner(action), "4");
        Thread t5 = new Thread(new Runner(action), "5");


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    public static class Runner implements Runnable {
        private Action action;

        public Runner(Action action) {
            this.action = action;
        }

        @Override
        public void run() {
            action.makeItSo();
        }

    }

    public static class Action {
        public synchronized void makeItSo() {
            for (int index = 0; index < 10; index++) {
                System.out.println(Thread.currentThread().getName() + " - " + index);
            }
        }
    }

}