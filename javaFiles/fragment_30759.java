public class ThreadExperiment implements Runnable {
    /* these fields are unique to each instance of ThreadExperiment */
    private int increment = 0;

    /* these are used to point to the original num1 and num2 instances created in your main method */ 
    private Integer myNumber;
    private Integer theOtherNumber;


/** 
 * Constructor.   
 */
public ThreadExperiment(int increment, Integer num1Ref, Integer num2Ref) {
    this.increment = increment;
    this.myNumber = num1Ref;
    this.theOtherNumber = num2Ref;
}


@Override
public void run() {
    do {
        myNumber += increment;
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + " -- " + myNumber);
    } while (!myNumber.equals(theOtherNumber));
}


/** 
 * Your static main method used to instantiate & start threads 
 */
public static void main(String[] args) {
    Integer num1 = 0;
    Integer num2 = 10;

    Thread t = new Thread(new ThreadExperiment(1, num1, num2), "Thread 1");
    Thread t2 = new Thread(new ThreadExperiment(-1, num2, num1), "Thread 2");
    t.start();
    t2.start();
}

}