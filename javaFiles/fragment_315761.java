public class SomeRunnable implements Runnable {
    private String name;
    public SomeRunnable(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        synchronized (System.out) {
           for(int i=0;i<50;i++) {
                NameShouter.shoutName(name);
            }
        }
    }
}

public class NameShouter {
    public static void shoutName(String name) {
        System.out.print(name);
    }
}