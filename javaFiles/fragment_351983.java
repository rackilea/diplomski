public class GoMyThread {
    public static void main(String[] args) {
            MyThread t1 = new MyThread("Louis");
            MyThread t2 = new MyThread("Mathilde");
            MyThread t3 = new MyThread("Toto");
            t1.start();
            t2.start();
            t3.start();
    }

    static class MyThread extends Thread {

        public MyThread(String name) {
            super(name);
        }

        public  void run() {
            for (int i = 0; i < 3; i++){
                    System.out.println(getName() + " Finish , level  " + (i+1));
                    try{
                        // Force a sleep to give the other threads time to reach the same level
                        Thread.sleep(500);
                    }catch (InterruptedException e) {
                        System.out.println("Something went wrong with sleep");
                    }

                    if (getName().compareTo("Louis") != 0){
                        try{
                            Thread.sleep(100);
                        }
                        catch (InterruptedException e){}
                    }
            }
        }
    }
}