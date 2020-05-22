// Register the listener
@Override
protected void onResume()
{
    // Register OnSharedPreferenceChangeListener
    PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).
    registerOnSharedPreferenceChangeListener(this);

    // Fire the base method
    super.onResume();
}

// Unregister the listener
@Override
protected void onPause()
{
    // Unregister OnSharedPreferenceChangeListener
    PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).
    unregisterOnSharedPreferenceChangeListener(this);

    // Fire  the base method
    super.onPause();
}