AlertDialog.Builder builder1 = new AlertDialog.Builder(this);

builder1.setMessage("Are you sure you want to exit?");
builder1.setCancelable(true);

builder1.setPositiveButton(
        "Yes",
        new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                MainActivity.this.finish();


            }
        });

builder1.setNegativeButton(
        "Cancel",
        new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

AlertDialog alert11 = builder1.create();
alert11.show();