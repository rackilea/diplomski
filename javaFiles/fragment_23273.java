public class Configuration {
    private static Context sContext;

    public static void initContext(Context context) {
        if (sContext == null) {
            sContext = context.getApplicationContext();
        }
    }    

    . . .
}