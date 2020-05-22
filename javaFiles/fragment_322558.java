final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
alertDialog.setTitle("Help :");
alertDialog.setMessage("Welcome to AndroidHive.info");
alertDialog.setButton(1,"OK", new OnClickListener() {

    @Override
    public void onClick(final DialogInterface dialog, final int which) {
        // TODO Auto-generated method stub
        alertDialog.cancel();
    }
});
alertDialog.show();