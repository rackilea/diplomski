public static AlertDialog.Builder getAlertDialog(final String strArray[],
        String strTitle, final Activity activity) {

    AlertDialog.Builder alertDialogBuilder =  
            new AlertDialog.Builder(activity);
    alertDialogBuilder.setTitle(strTitle);

    alertDialogBuilder.setItems(strArray,
            new DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface dialog, int which) {
           Toast.makeText(activity, strArray [which], Toast.LENGTH_SHORT).show();

           //rest of your implementation
        }
    });
   return alertDialogBuilder;
}