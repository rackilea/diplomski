import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class AppPreference {
    String DEVELOPERPAYLOAD = "DEVELOPERPAYLOAD";
    String PURCHASETOKEN = "PURCHASETOKEN";
    //Configuration Variable
    private static AppPreference singletonPreference = null;
    private SharedPreferences sp;

    private Context context;

    private AppPreference(Context context) {
        if (context == null)
            return;
        this.context = context;
        sp = context.getSharedPreferences(Constants.sharedPreference.PREFERENCE, 0);
    }

    public static AppPreference getInstance(Context context) {
        if (singletonPreference == null)
            singletonPreference = new AppPreference(context);
        return singletonPreference;
    }

    public void clearOnlogout() {
        Editor prefsEditor = sp.edit();
        prefsEditor.clear();
        prefsEditor.apply();
    }

    void removeData(String key) {
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.apply();
    }

    public void setStringData(String pKey, String pData) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(pKey, pData);
        editor.apply();
    }

    public void setBooleanData(String pKey, boolean pData) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(pKey, pData);
        editor.apply();
    }

    void setIntegerData(String pKey, int pData) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(pKey, pData);
        editor.apply();
    }

    public String getStringData(String pKey) {
        return sp.getString(pKey, "");
    }

    public boolean getBooleanData(String pKey) {
        return sp.getBoolean(pKey, false);
    }

    public int getIntegerData(String pKey) {
        return sp.getInt(pKey, 0);
    }

    public String getDeveloperPayload() {
        return sp.getString(DEVELOPERPAYLOAD, "");
    }

    public void setDeveloperPayload(String developerPayload) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(DEVELOPERPAYLOAD, developerPayload);
        editor.apply();
    }


}