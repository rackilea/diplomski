public class PreferenceValues {

private boolean isFirstRun;


private String daysPresent;
private String daysAbsent;
private String percentage;


private Editor ed;


private static PreferenceValues mInstance = null;


private static SharedPreferences prefs;

private PreferenceValues(Context context) {
    super();
}

/**
 * Creating a singleton insatnce of the class
 * 
 * @param ctx
 * @return instance of the class
 */
public static PreferenceValues getInstance() {
    Context ctx = MyApplication.getInstance().getApplicationContext();
    if (mInstance == null) {
        mInstance = new PreferenceValues(ctx);
    }
    prefs = ctx
            .getSharedPreferences("MyPreferencess", Context.MODE_PRIVATE);

    return mInstance;
}

/**
 * To check if the application is running for the first time
 * 
 * @return
 */
public boolean isFirstRun() {
    return prefs.getBoolean("isfirstruns", true);

}

/**
 * To update the flag for the first run
 * 
 * @param isFirstRun
 */
public void setIsFirstRun(Boolean isFirstRun) {
    this.isFirstRun = isFirstRun;
    ed = prefs.edit();
    ed.putBoolean("isfirstruns", this.isFirstRun);
    ed.commit();
}


public String getDaysPresent() {
    return prefs.getString("daysPresent", "0");
}

public void setDaysPresent(String daysPresent) {
    this.daysPresent = daysPresent;
    ed = prefs.edit();
    ed.putString("daysPresent", this.daysPresent);
    ed.commit();
}

public String getdaysAbsent() {
    return prefs.getString("daysAbsent", "0");
}

public void setdaysAbsent(String daysAbsent) {
    this.daysAbsent = daysAbsent;
    ed = prefs.edit();
    ed.putString("daysAbsent", this.daysAbsent);
    ed.commit();
}

public String getpercentage() {
    return prefs.getString("percentage", "0.00");
}

public void setpercentage(String percentage) {
    this.percentage = percentage;
    ed = prefs.edit();
    ed.putString("percentage", this.percentage);
    ed.commit();

}

}