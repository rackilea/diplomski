public class LifeMatrix {
    private CyclicBarrier cycleBarrier;
    private CyclicBarrier cellUpdateBarrier;
    //.....

    public LifeMatrix(int length, int width) {
        cycleBarrier = new CyclicBarrier(length * width + 1);
        cellUpdateBarrier = new CyclicBarrier(length * width);

        // follow logic of old constructor
    }

    public void changeAction(Action a) {
        //....
        cycleBarrier.await()
    }

    // inner class for cell
    public class Cell implements Runnable {
        // ....

        @Override
        public void run() {
             while (...) {
                 cycleBarrier.await();  // wait until start of cycle
                 boolean isAlive = decideNewLifeState();
                 cellUpdateBarrier.await();  // wait until everyone completed
                 this.alive = isAlive;
             }
        }
    }
}