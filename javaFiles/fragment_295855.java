//We will pass our Activity context
public void AlertWifi( Context ctx,String msg) {
    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ctx);
    dlgAlert.setMessage(msg);
    dlgAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int whichButton) {
            dialog.dismiss();
        }
    });
    dlgAlert.setPositiveButton("Yes",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    Intent i=new Intent(
                            android.provider.Settings.ACTION_WIFI_SETTINGS);
                            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);

                }
            });
    dlgAlert.setCancelable(false);
    dlgAlert.create().show();
}

}