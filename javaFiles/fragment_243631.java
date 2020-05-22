public void createDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setMessage("Do you want to exit from app");
    builder.setCancelable(false);
    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    });

    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(MainActivity.this, "You exit from app",
                    Toast.LENGTH_LONG).show();

        }
    });

    AlertDialog alert = builder.create();
    alert.show();
    Button nbutton = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
    nbutton.setBackgroundColor(Color.MAGENTA);
    Button pbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE);
    pbutton.setBackgroundColor(Color.YELLOW);
}