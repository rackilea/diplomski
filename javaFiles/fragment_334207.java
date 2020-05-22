public class MainActivity extends Activity {

Button btnRegId;
EditText etRegId;
String regID;

GoogleCloudMessaging gcm;
String regid, url;

//String PROJECT_NUMBER = "90787073097";
String PROJECT_NUMBER = "440085976573";


String android_id, version, ver;


ImageView mega4, todayTips, latstnews, sportquiz, tipister;

TextView txtname;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // etRegId = (EditText) findViewById(R.id.edtvID);


    //********************For Rating APP **********************
    SharedPreferences sharedPrefs = MainActivity.this.getSharedPreferences("RATER", 0);
    if (sharedPrefs.getBoolean("NO THANKS", false)) {
        return;
    } else {
        SharedPreferences.Editor prefsEditor = sharedPrefs.edit();
        //YOUR CODE TO SHOW DIALOG
        long time = sharedPrefs.getLong("displayedTime", 0);
        if (time < System.currentTimeMillis() - 259200000) {
            displayDialog();
            prefsEditor.putLong("displayedTime", System.currentTimeMillis()).commit();
        }
        prefsEditor.apply();
    }


}

//dialog box Function for rating app.

private void displayDialog() {
    // TODO Auto-generated method stub
    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    //Yes button clicked
                    Intent in = new Intent(android.content.Intent.ACTION_VIEW);
                    in.setData(Uri.parse(url));
                    startActivity(in);
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    //Saving a boolean on no thanks button click

                    SharedPreferences prefs = MainActivity.this.getSharedPreferences("RATER", 0);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("NO THANKS", true);
                    editor.apply();
                    break;
            }
        }
    };

    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
    builder.setTitle("Rate This App");
    builder.setMessage("You really seem to like this app, "
            + "since you have already used it %totalLaunchCount% times! "
            + "It would be great if you took a moment to rate it.")
            .setPositiveButton("Rate Now", dialogClickListener)
            .setNegativeButton("Latter", dialogClickListener)
            .setNeutralButton("No,thanks", dialogClickListener).show();

}
//End dialog box Function for rating app.
    }