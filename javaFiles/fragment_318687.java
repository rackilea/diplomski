public class TestClass {
    private static final Vector vector = new Vector();

    public static void iterate() {
        for (int i = 0; i < vector.size(); i++) {
            doSomething(vector.get(i));
        }
    }

    public static void main (String... args) {
            //initialize vector and fill it
        new Thread( new Runnable() {
            @Override
            public void run() {
                iterate();
            }
        }, "A").start();

        new Thread( new Runnable() {
            @Override
            public void run() {
                vector.clear();
            }
        }, "B").start();
    }

    private static void doSomething(Object object) {
        //DO SMTHNG.
    }
}