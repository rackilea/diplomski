// Get a reference to the Shared Preferences Editor
editor = sharedPreferences.edit();

// Store your values
editor.putInt("spinnerSelection1",selectedposition1);
editor.putInt("spinnerSelection2",selectedposition2);
editor.putInt("spinnerSelection3",selectedposition3);
editor.apply(); // Submit your changes to the Shared Preferences