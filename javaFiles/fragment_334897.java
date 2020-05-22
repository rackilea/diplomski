// "top level" class -- in MyWhatever.java
public class MyWhatever {

    // anonymous class
    public static final Runnable anonymousRunnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("I am an anonymous Runnable.");
        }
    }

}