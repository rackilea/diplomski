private void confirmDialog(Context context){ 

   final AlertDialog alert = new AlertDialog.Builder(
                    new ContextThemeWrapper(context,android.R.style.Theme_Dialog))
                    .create();
            alert.setTitle("Alert");
            alert.setMessage("Do you want to exit ?");
            alert.setIcon(R.drawable.warning_icon);
            alert.setCancelable(false);
            alert.setCanceledOnTouchOutside(false);

            alert.setButton(DialogInterface.BUTTON_POSITIVE, "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            alert.dismiss();

                            finish();

                        }
                    });

            alert.setButton(DialogInterface.BUTTON_NEGATIVE, "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            alert.dismiss();

                        }
                    });

            alert.show();
}