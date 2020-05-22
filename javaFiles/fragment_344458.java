@Override
public void onResume() {
    super.onResume();  // Always call the superclass method first

    // Restore preferences
    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
    String yourRetrievedStringValue = settings.getString("yourKey", "");
    TextView yourTextView = findViewById(R.id.yourTextViewId);
    yourTextView.setText(yourRetrievedStringValue);

}