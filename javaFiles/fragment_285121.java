//instance variable in the Mainactivity.class
private boolean showMessage = true;

SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
String username = sharedPref.getString("username", null);
if(username == null){
    //first time user - ask for username
    SharedPreferences.Editor editor = sharedPref.edit();
    editor.putString("username", enteredName);
    editor.commit();
    showMessage = false;
} else if(showMessage) {
    showMessage = false;
    //greet
    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
    alert.setMessage("Hello " + username + "!")
            .setCancelable(true)
            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
    alert.create().show();
}