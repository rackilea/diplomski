public void registrationSuccess(context, String warning, String message) {
    alert = new AlertDialog.Builder(context);
    alert.setTitle(warning);
    alert.setMessage(message)
            .setCancelable(false)
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Intent i = new Intent(context, loginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(i);
                }
            });
    AlertDialog alertDialog = alert.create();
    alert.show();
}