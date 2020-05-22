AlertDialog.Builder builder = new AlertDialog.Builder(context);
builder.setTitle("Message")
    .setMessage(str)
    .setNeutralButton("OK", null);

AlertDialog dialog = builder.create();
dialog.show();