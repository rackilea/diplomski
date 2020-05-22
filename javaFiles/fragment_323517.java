IDialogSettings settings = Activator.getDefault().getDialogSettings();

// Access an array of values stored in the settings

String [] valuesArray = settings.getArray("key for value");

// Save array of strings in the settings
settings.put("key for value", valuesArray);