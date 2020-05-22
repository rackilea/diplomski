private class DialogDemo implements DialogInterface.OnClickListener{

    @Override
    public void onClick(DialogInterface dialog, int which) {
        Toast.makeText(getBaseContext(),“OK clicked!”, 
                Toast.LENGTH_SHORT).show();
}
}