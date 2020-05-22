// Create your dialog builder
AlertDialog.Builder builder = new AlertDialog.Builder(context);
// Apply your custom view
builder.setView(R.layout.custom);
// A null clickListener will cancel the dialog
builder.setNegativeButton("Cancel" /*TODO Replace with string resources*/, null);
// Show the dialog
builder.show();