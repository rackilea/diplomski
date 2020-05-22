public class UserProfileProvider extends ContentProvider implements SharedPreferences {


    @Override
    public boolean onCreate() {
        SharedPreferences settings = getContext().getSharedPreferences(getContext().getResources().getString(R.string.PREFS_NAME), getContext().MODE_PRIVATE);
        Log.d("akis", ":::userProfileProvider:::" + settings.getString(getContext().getResources().getString(R.string.USER_PREFERENCES), "default"));
        return false;
    }