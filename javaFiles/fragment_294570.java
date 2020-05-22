AlertDialog.Builder builder = new AlertDialog.Builder(activity);
builder.setTitle("ALERTTILESTRING");
builder.setMessage("alertNameString");
builder.setCancelable(false);
builder.setNegativeButton("Close",new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int id) {
        dialog.cancel();
    }
});

AlertDialog alert = builder.create();
alert.show();