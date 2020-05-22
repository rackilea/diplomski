public class DatabaseUtils {
    public static void close(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // I'll leave the others for you.
}