SharedPreferences preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);

boolean hasBeenChecked = preferences.getBoolean("checkBox", false);

if (!hasBeenChecked) {

AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle(" TITLEs");
    builder.setMessage(" blablabla ")
           .setView(checkBoxView)
           .setCancelable(false)

           .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
               }
           }).show();
}