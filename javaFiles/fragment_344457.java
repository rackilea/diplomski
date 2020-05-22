@Override
public void onPause() {
    super.onPause();  // Always call the superclass method first

    String yourStringValues = yourTextView.getText().toString();

    // We need an Editor object to make preference changes.
    // All objects are from android.context.Context
    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
    SharedPreferences.Editor editor = settings.edit();
    editor.putString("yourKey", yourStringValue);

    // Commit the edits!
    editor.commit();
}