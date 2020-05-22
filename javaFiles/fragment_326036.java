dialog.setPositiveButton("Done", new DialogInterface.OnClickListener() {

    @Override
    public void onClick(DialogInterface dialog, int which) {
        // your original code
        if(result < 5 || result > 60)      
            CannonView.timeRemaining = 10;
        else  CannonView.timeRemaining = result;
});