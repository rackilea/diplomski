LayoutInflater inflater = LayoutInflater.from(YourActivity.this);
final View yourCustomView = inflater.inflate(R.layout.mycustomdialog, null);

final TextView etName = (EditText) yourCustomView.findViewById(R.id.EditZip);
AlertDialog dialog = new AlertDialog.Builder(YourActivity.this)
    .setTitle("Enter the Zip Code")
    .setView(yourCustomView)
    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int whichButton) {
            mSomeVariableYouHaveOnYourActivity = etName.getText().toString();
        }
    })
    .setNegativeButton("Cancel", null).create();
dialog.show();