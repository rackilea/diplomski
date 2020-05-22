AlertDialog alertDialog = new AlertDialog.Builder(this)
 .setIcon(android.R.drawable.ic_dialog_alert)
.setTitle("Title")
.setMessage("Show Message here")
.setPositiveButton("Button A", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        startActivity(new Intent(this,ActivityA));  

    }
})

.setNegativeButton("Button B", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
     startActivity(new Intent(this,ActivityB));

    }
})
.show();