public class MenuHelper {

    public static void build(Menu menu) {
        menu.add(Menu.NONE, Key.Activity.LOGOUT, 0, R.string.label_logout)
                .setIcon(android.R.drawable.ic_menu_close_clear_cancel);
        menu.add(Menu.NONE, Key.Activity.FEEDBACK, 0,
                com.bytebenderapps.dbitly.R.string.label_feedback).setIcon(
                android.R.drawable.ic_menu_send);
    }

    public static boolean onMenuItemSelected(int featureId, MenuItem item,
            Context context) {
        switch (item.getItemId()) {
        case Key.Activity.LOGOUT:

            removeCredentials(context);
            startLoginActiviy(context);

            break;
        case Key.Activity.FEEDBACK:

            startFeedbackActivity(context);

            break;
        }

        return true;
    }

    private static void startLoginActiviy(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);

        context.startActivity(intent);
    }

    private static void removeCredentials(Context context) {
        Editor editor = PreferenceManager.getDefaultSharedPreferences(context)
                .edit();

        editor.clear();
        editor.commit();
    }

    public static void toggleLogoff(Menu menu, boolean userLoggedIn) {
        MenuItem item = menu.findItem(Key.Activity.LOGOUT);

        item.setEnabled(userLoggedIn);
    }

    private static void startFeedbackActivity(Context context) {
        context.startActivity(new Intent(context, FeedbackActivity.class));
    }
}