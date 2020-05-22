private String getStringResourceByName(String aString) {
  String packageName = getPackageName();
  int resId = getResources().getIdentifier(aString, "string", packageName);
  return getString(resId);
}


thing.setText(getStringResourceByName("question1"));