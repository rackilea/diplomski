public void savePreferences()
{
    defaultVolumeUnit = MySingleton.getInstance().getDefaultVolumeUnit();
    defaultPressureUnit = MySingleton.getInstance().getDefaultPressureUnit();
    defaultTempUnit = MySingleton.getInstance().getDefaultTempUnit();

    //settings = getSharedPreferences(SettingsTAG, 0);
    settings = PreferenceManager.getDefaultSharedPreferences(context); // Notice CONTEXT!
    Editor editor = settings.edit();

    editor.putInt("selectVolume", defaultVolumeUnit);
    editor.putInt("selectPressure", defaultPressureUnit);
    editor.putInt("selectTemperature", defaultTempUnit);

    editor.commit();
}