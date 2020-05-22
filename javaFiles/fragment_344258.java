@Override
public void onSaveInstanceState(Bundle savedInstanceState) {
  super.onSaveInstanceState(savedInstanceState);
  savedInstanceState.putBoolean("myCheckboxState", myCheckBox.isChecked());
  savedInstanceState.putDouble("myDouble", 1.9);
  savedInstanceState.putInt("myInt", 1);
  savedInstanceState.putString("myTextViewString", myTextView.getText());
  // etc.
}