AlertDialog.Builder builder = new AlertDialog.Builder(context);
builder.setTitle("Title");
final View v = LayoutInflater.from(context).inflate(R.layout.dialog_view, null);
builder.setView(v);
builder.setNegativeButton("Cancel", null);
builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
       mInput = ((EditText)v.findViewById(R.id.etxtDialog)).getText().toString();
    }
});
builder.show();