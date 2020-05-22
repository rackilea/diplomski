public class TestThreads {
    public static void main(String[] args)
    {
        DataShare ds = new DataShare();
        B b = new B(ds);
        A a = new A(100, ds);

        b.start();
        a.start();

        try {
            a.join(); // Waiting for A to die
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println ("Accumulated total from B = " + b.getTotal());      
        b.endThread();
    }   
}


public class DataShare {
    private int value;

    public DataShare () {
        value = -1;
    }

    public synchronized boolean setValue(int val) {
        boolean valueSet = false;
        if (value == -1) {
            value = val;
            valueSet = true;
        }
        return valueSet;        
    }

    public synchronized int getValue() {
        int val = value;
        value = -1;
        return val;
    }    
}


public class A extends Thread {
    private int max;
    private DataShare dataShare;

    public A (int n, DataShare ds) {
        max = n;
        dataShare = ds;
    }

    public void run() {
        int i = 0;
        while (i < max) {
            if (dataShare.setValue(i)) {
                i++;
            }
        }
    }
}


public class B extends Thread {
    private int total;
    private DataShare dataShare;
    private boolean running = false;

    public B (DataShare ds) {
        dataShare = ds;
        total = 0;
    }

    public void run() {
        running = true;
        while (running) {
            int nextValue = dataShare.getValue();
            if (nextValue != -1) {
                total += nextValue;
            }
        }
    }

    public int getTotal() {
        return total;
    }

    public synchronized void endThread() {
        running = false;
    }
}