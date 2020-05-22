@Override
public void onBackPressed() {
    AlertDialog.Builder builder = new AlertDialog.Builder(context);
    builder.setMessage("Are you sure you want to exit?")
            .setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                            finish();
                        }
                    })
            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    dialog.dismiss();
                }
            });
    // Create the AlertDialog object and return it
    builder.create();
    builder.show();
}