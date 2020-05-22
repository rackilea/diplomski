private static final String SELECTED_ITEM = "SelectedItem";
private SharedPreferences sharedPreference;
private Editor sharedPrefEditor;

private void showAlert() {
    final CharSequence[] items = {"Red", "Green", "Blue"};

    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Pick a color");               
    builder.setSingleChoiceItems(items, getSelectedItem(), new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int item) {
            saveSelectedItem(item);
            Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
        }       
    });
    AlertDialog alert = builder.create();
    alert.show();

}

private int getSelectedItem() {
    if (sharedPreference == null) {
        sharedPreference = PreferenceManager
                .getDefaultSharedPreferences(this);
    }
    return sharedPreference.getInt(SELECTED_ITEM, -1);
}

private void saveSelectedItem(int item) {
    if (sharedPreference == null) {
        sharedPreference = PreferenceManager
                .getDefaultSharedPreferences(this);
    }
    sharedPrefEditor = sharedPreference.edit();
    sharedPrefEditor.putInt(SELECTED_ITEM, item);
    sharedPrefEditor.commit();
}