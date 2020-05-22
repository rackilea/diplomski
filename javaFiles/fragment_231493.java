public class MyRunnableTask implements Runnable {

    @Override
    public void run() {
        System.out.println("I am getting executed: " + this.hashCode() + " | " + Thread.currentThread().getId());
        try {
            Thread.sleep(2000); // this sleep is only for testing to give a feel of how solution will work, remove after testing.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}