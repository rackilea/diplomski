public class GsonUtils {
    private static final Gson INSTANCE = new Gson();

    private GsonUtils() {
        // you do not want someone to instantiate this
    }

    public static Gson getInstance() {
        return INSTANCE;
    }
}