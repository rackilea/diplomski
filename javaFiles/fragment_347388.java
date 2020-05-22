AlertDialog.Builder builder = new AlertDialog.Builder(this);
builder.setMessage("Launch a website?");
builder.setPositiveButton(getString(R.string.yes),
    new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW,
            Uri.parse("http://www.somewebsite.com"));
            startActivity(browserIntent);
            finish();
        }
    }
);
builder.setNegativeButton(getString(R.string.no),
    new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            //some other thing to do
        }
    }
);

AlertDialog dialog = builder.create();
dialog.show();