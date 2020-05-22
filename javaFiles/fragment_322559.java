final AlertDialog alertDialog = new AlertDialog.Builder(this)

.setTitle("Help :")
.setMessage("Welcome to AndroidHive.info")
.setNegativeButton("OK", new OnClickListener() {

    @Override
    public void onClick(final DialogInterface dialog, final int which) {
        // TODO Auto-generated method stub
        alertDialog.cancel();
    }
})
.create();

alertDialog.show();