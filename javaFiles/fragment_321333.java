public class LocationService extends Service {
  private SharedPreferences sharedPref;

  public void onCreate() {
    super.onCreate();

    sharedPref=PreferenceManager.getDefaultSharedPreferences(this);
  }

  // other cool stuff here
}