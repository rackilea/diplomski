public class GsonUtils {
    private static Gson INSTANCE;

    private GsonUtils() {
        // you do not want someone to instantiate this
    }

    public static Gson getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Gson();
        }
        return INSTANCE;
    }
}