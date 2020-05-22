WeakReference<Context> wm;
    /**
     * 
     * @param ctx Activity context
     * @param msg Message that will be displayed
     */
public void AlertWifi( Context ctx,String msg) {
    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ctx);
    wm=new WeakReference<Context>(ctx);
    dlgAlert.setMessage(msg);
    dlgAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int whichButton) {
            dialog.dismiss();
        }
    });
    dlgAlert.setPositiveButton("Yes",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    Context ctx=wm.get();
                    if(ctx!=null){
                    Intent i=new Intent(
                            android.provider.Settings.ACTION_WIFI_SETTINGS);
                            //i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                      ctx.startActivity(i);
                    }

                }
            });
    dlgAlert.setCancelable(false);
    dlgAlert.create().show();
}