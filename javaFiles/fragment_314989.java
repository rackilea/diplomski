class MyMonitor {
private enum States {THINKING, HUNGRY, EATING};
private  States[] state;

public MyMonitor() {
    state = new States[5];
    for(int i = 0; i < 5; i++) {
        state[i] = States.THINKING;
        System.out.println("Philosopher " + i + " is THINKING");
    }
}

private synchronized void test(int i) {
    while((state[(i+4)%5]!=States.EATING) && (state[i]==States.HUNGRY) && (state[(i+1)%5]!=States.EATING)) {
        state[i] = States.EATING;
        System.out.println("Philosopher " + i + " is EATING");
     //   notify();
    }
}

public synchronized void pickup(int i) {
        state[i] = States.HUNGRY;
        System.out.println("Philosopher " + i + " is HUNGRY");      
        test(i);
        if (state[i] != States.EATING) {
            System.out.println("Philosopher " + i + " is WAITING");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}

public synchronized void putdown(int i) {
        state[i] = States.THINKING;
        System.out.println("Philosopher " + i + " is THINKING");
        //test((i+4)%5);
        //test((i+1)%5);
        notifyAll();
    }
}