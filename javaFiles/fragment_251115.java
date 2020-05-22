public class Main {

    private static volatile String alpha = null;

    public static void main(String[] args) {

        new Thread() {
            @Override
            public void run() {
                alpha = "new value";
            }
        }.start();

        while (alpha == null);   // We wait until the variable is non-null.
        System.out.println(alpha);
    }
}