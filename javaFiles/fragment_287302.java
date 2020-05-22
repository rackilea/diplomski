AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity)
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                activity.startActivity(new Intent(activity, DetailView.class));
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();