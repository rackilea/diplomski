Builder builder = new AlertDialog.Builder(this);
builder.setMessage("Connection Error:  Retry?");
builder.setCancelable(true);
builder.setPositiveButton("Retry", new RetryOnClickListener());
builder.setNegativeButton("Cancel", new CancelOnClickListener());
AlertDialog dialog = builder.create();

//Add this
dialog.setCanceledOnTouchOutside(false);

dialog.show();