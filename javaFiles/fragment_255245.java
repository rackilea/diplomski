public class ThreadSafe {

    private static final Object monitor = new Object();
    private static final String data;

    static {
        setData();
    }

    private static void setData() {         
            data = String.valueOf(System.currentTimeMillis());
    }

    public static String getData() {
        synchronized(monitor) {
            if (data.indexOf("7") < 0) { 
                // recalculate invalid data
                setData();
            }
            return data;
        }
    }
}