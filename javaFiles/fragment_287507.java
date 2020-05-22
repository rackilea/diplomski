// Get your reference to Shared Preferences
// (You only need to do this once to store & retrieve your variables from the same file)
sharedPreferences = getSharedPreferences("My_Shared_Prefs", MODE_PRIVATE);

// Retrieve values from Shared Preferences with a fallback to your default value
int settings1 = sharedPreferences.getInt("spinnerSelection1",0);
int settings2 = sharedPreferences.getInt("spinnerSelection2",0);
int settings3 = sharedPreferences.getInt("spinnerSelection3",0);

// Set the selected position for each Spinner
spin1.setSelection(settings1);
spin2.setSelection(settings2);
spin3.setSelection(settings3);