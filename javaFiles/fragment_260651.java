@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initialize(new ConfirmTest(this), false);
}

@Override
public void confirm(final ConfirmInterface confirmInterface) {
    runOnUiThread(new Runnable(){
   @Override
   public void run() {
    new AlertDialog.Builder(ConfirmTestAndroidActivity.this)                                     
            .setTitle("Confirm")
            .setMessage("Are you sure?")                                            
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    confirmInterface.yes();
                    dialog.cancel();
                }
            })
            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            })
           .create().show();        
   }        
});
}