public class StringBufferTest {

    public static void unsync() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 9999999; i++) {
            buffer.append(i);
            buffer.delete(0, buffer.length() - 1);
        }

    }

    public static void sync() {
        StringBuffer buffer = new StringBuffer();
        synchronized (buffer) {
            for (int i = 0; i < 9999999; i++) {
                buffer.append(i);
                buffer.delete(0, buffer.length() - 1);
            }
        }
    }

    public static void sb() {
        StringBuilder buffer = new StringBuilder();
        synchronized (buffer) {
            for (int i = 0; i < 9999999; i++) {
                buffer.append(i);
                buffer.delete(0, buffer.length() - 1);
            }
        }
    }    

    public static void main(String[] args) {

        System.out.println(System.getProperty("java.version"));

        // warm up
        for(int i = 0 ; i < 10 ; i++){
            unsync();
            sync();
            sb();
        }

        long start = System.currentTimeMillis();
        unsync();
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println("Unsync: " + duration);

        start = System.currentTimeMillis();
        sync();
        end = System.currentTimeMillis();
        duration = end - start;
        System.out.println("sync: " + duration);

        start = System.currentTimeMillis();
        sb();
        end = System.currentTimeMillis();
        duration = end - start;
        System.out.println("sb: " + duration);  
    }
}