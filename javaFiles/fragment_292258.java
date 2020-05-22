public class Helper {

    private static SomeObject obj;
    private static final Object mutex = new Object();

    public static void changeMember() {
        synchronized (mutex) {
            obj.changeValue();
        }
    }

    public static String readMember() {
        synchronized (mutex) {
            obj.readValue();
        }
    }
}