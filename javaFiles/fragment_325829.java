public class ASharedPreferences {

    private static final String PREF_NAME = 'Number';

    public static void saveCurrentNumber(Context context) {
        SharedPreferences sSharedPref=context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
       SharedPreferences.Editor sEditor=sSharedPref.edit();
        sEditor.putInt("current_number", getCurrentNumber(context) + 1);
        sEditor.apply();
    }

    public static int getCurrentNumber(Context context) {
       SharedPreferences sSharedPref=context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
       SharedPreferences.Editor sEditor=sSharedPref.edit();
        return sSharedPref.getInt("current_number", 0);
    }

}