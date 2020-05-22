progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, “OK”,
new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog,int whichButton)
    {
        Toast.makeText(getBaseContext(),“OK clicked!”, 
            Toast.LENGTH_SHORT).show();
    }
});