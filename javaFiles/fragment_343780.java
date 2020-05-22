/**
 *
 * Created by App Studio 35 on 6/27/17.
 */
public class IntentFactory {

    /**
     *
     * @param context
     * @return intent
     */
    public static Intent getLoginIntent(Context context, boolean launchedFromNotification, String idOfDetailToOpen){
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra(Globals.INTENT_KEYS.KEY_FROM_BADGE_ACCESS, launchedFromNotification);
        intent.putExtra(Globals.INTENT_KEYS.KEY_ID_OF_DETAIL_TO_OPEN, idOfDetailToOpen); 
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;

    }
    /**
     *
     * @param context
     * @return
     */
    public static Intent getSettingsIntent(Context context){
        Intent intent = new Intent(context, SettingsActivity.class);
        return intent;
    }
    /**
     *
     * @param filePath
     * @param subject
     * @param body
     * @return
     */
    public static Intent getSendImageIntent(String filePath, String subject, String body){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/jpg");
        intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + filePath));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        return Intent.createChooser(intent, "Share File");

    }
    /**
     *
     * @param toEmailAddresses
     * @param subject
     * @param body
     * @param uris
     * @return
     */
    public static Intent getEmailIntent(String[] toEmailAddresses, String subject, String body, ArrayList<Uri> uris) {
        Intent intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, toEmailAddresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        if(uris != null) {
            intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);

        }

        return Intent.createChooser(intent, "Send mail...");

    }
    /**
     * Used to launch to app details screen for toggling of permissions or other things
     * @param context
     * @return
     */
    public static Intent getShowAppDetailSettingsIntent(Context context){
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        return intent;

    }

}