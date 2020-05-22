public class Helper
{

    public static void goHome(Context context, Class<?> cls) {
        Intent explicitIntent = new Intent(context, cls);
        context.startActivity(explicitIntent);
    }

}