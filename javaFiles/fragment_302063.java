new AlertDialog.Builder(Activity.this)
    .setMessage("You have unsaved text. Are you sure you want to leave?")
    .setCancelable(true)
    .setOnCancelListener(new DialogInterface.OnCancelListener() {
        @Override
        public void onCancel(DialogInterface dialog) 
        {
            // do what you need when the dialog is cancelled
        }
    })
    .setNegativeButton("Leave", new DialogInterface.OnClickListener() { 
        public void onClick(DialogInterface dialog, int id) 
        {
            finish();
        }
    })
    .setPositiveButton("Stay", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {}
    }).show();