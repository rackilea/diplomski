public void showAlertDialog(String title, String message, Context context)
{
    final AlertDialog alertDialog = new AlertDialog.Builder(context).create();

    alertDialog.setTitle(title);
    alertDialog.setMessage(message);
    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            alertDialog.dismiss();
        }
    });

    alertDialog.show();
}