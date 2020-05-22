String restoredText;
String restoredname;

public void addNotification(Context context) {
    getPref(context);
    String myString = restoredText + " " + restoredname;
    ...
    .setContentText(myString)
    ...
}

public void getPref(Context context) {
    restoredText = sp.getString("purpose", "");
    restoredname = sp.getString("name", "");
}