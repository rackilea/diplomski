public static void LocationAlertDialog(final Context context) {

    AlertDialog.Builder d = new AlertDialog.Builder(context);
    d.setTitle("No Providers");
    d.setMessage("Unfortunately, you don't have any providers to get your location, would you like to turn on your GPS?");

    d.setNegativeButton(context.getResources().getString(R.string.dialogCancel), new OnClickListener() {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            // TODO Auto-generated method stub
        }
    });

    d.setPositiveButton(context.getResources().getString(R.string.dialogAccept), new OnClickListener() {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            // TODO Auto-generated method stub
            Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            context.startActivityForResult(i, 0);
        }
    });

    d.show();
}