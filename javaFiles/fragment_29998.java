public class SyncProblem {

    public static void main(String[] args) {
        Parent parent = new Parent();
        new Thread(parent.new GettingVaribale()).start();
        new Thread(parent.new UpdatingVaribale()).start();
    }
}

class Parent {
    private volatile int value = -1;

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    class UpdatingVaribale implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                setValue(2);
                Thread.currentThread().interrupt();
            }
        }
    }

    class GettingVaribale implements Runnable {
        @Override
        public void run() {
            while (getValue() == -1) {
                try {
                    System.out.println(getValue());
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
            System.out.println(getValue());
        }
    }
}