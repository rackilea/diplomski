private SharedPreferences prefSettings;

public void restoreValues()
{
    prefSettings = PreferenceManager.getDefaultSharedPreferences(this);

    int SelectedVolume = prefSettings.getInt("selectVolume", 0);
    int SelectedPressure = prefSettings.getInt("selectPressure", 0);
    int SelectedTemperature = prefSettings.getInt("selectTemperature", 0);

    // Necessary assignments here...
}