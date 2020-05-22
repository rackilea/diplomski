protected void onSaveInstanceState(Bundle outState) {
    // Save the calculator display text.
    outState.putString("displayText", calcDisplay.getText());
}

protected void onCreate(Bundle savedInstanceState) {

    // ...

    // Restore the calculator display text.
    if (savedInstanceState != null) {
        String displayText = savedInstanceState.getString("displayText");
        calcDisplay.setText(displayText);
    }
}