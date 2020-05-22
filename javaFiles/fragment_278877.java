dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
    @Override
    public void onClick(DialogInterface dialog, int which){
        // Do some positive stuff here!
    }
});
dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
    @Override
    public void onClick(DialogInterface dialog, int which){
        // Do some negative stuff here!
    }
});