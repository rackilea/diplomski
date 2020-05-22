public class UnreferencedTest {

    public static void main(String[] args) {
        UnreferencedTest u = new UnreferencedTest();
        u.createObject();
    }

    private void createObject() {

        Unreferenced obj = new Unreferenced();
        Thread t = new Thread(obj);//create new thread
        t.start();
        obj = null;     //remove only reference to object
        System.gc();    //ask GC to clean up

        try {
            Thread.sleep(10000); //wait a bit longer than other thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class Unreferenced implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                areYouStillHere();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void areYouStillHere() {
            System.out.println("I'm still here!");
        }
    }

}